package com.damon.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled "+
					"from user_accounts where username = ?")
			.authoritiesByUsernameQuery("select username, role "+
					"from user_accounts where username = ?")
		.passwordEncoder(bCryptEncoder);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests() //the order in antMatchers matters, most priority at the top to restrict access
		.antMatchers("/projects/new").hasAuthority("ADMIN")
		.antMatchers("/projects/save").hasAuthority("ADMIN")
		.antMatchers("/employees/new").hasAuthority("ADMIN")
		.antMatchers("/employees/save").hasAuthority("ADMIN")
		//.antMatchers("/h2_console/**").permitAll()
		.antMatchers("/", "/**").permitAll()
		.and()
		.formLogin()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login"); //formLogin().loginPage("/login-page") would be used for a custom login page
		
		//used just for h2 console to work never use in production
		//http.csrf().disable();
		//http.headers().frameOptions().disable();
	}
	
}
