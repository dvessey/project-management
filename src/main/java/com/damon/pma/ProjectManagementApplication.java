package com.damon.pma;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.damon.pma.dao.EmployeeRepository;
import com.damon.pma.dao.ProjectRepository;
import com.damon.pma.entities.Employee;
import com.damon.pma.entities.Project;

@SpringBootApplication
public class ProjectManagementApplication {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository proRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
	//SEED THE DATABASE WITH DATA
//	@Bean
//	CommandLineRunner runner() {
//		
//		return args -> {
//			
//			Employee emp1 = new Employee("John", "Warton", "warton@gmail.com");
//			Employee emp2 = new Employee("Mike", "Lanister", "lanister@gmail.com");
//			Employee emp3 = new Employee("Steve", "Reeves", "Reeves@gmail.com");
//			
//			Employee emp4 = new Employee("Ronald", "Connor", "connor@gmail.com");
//			Employee emp5 = new Employee("Jim", "Salvator", "Sal@gmail.com");
//			Employee emp6 = new Employee("Peter", "Henley", "henley@gmail.com");
//
//			Employee emp7 = new Employee("Richard", "Carson", "carson@gmail.com");
//			Employee emp8 = new Employee("Honor", "Miles", "miles@gmail.com");
//			Employee emp9 = new Employee("Tony", "Roggers", "roggers@gmail.com");
//
//			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck "
//						+ "the final deployment of the software into production");
//			Project pro2 = new Project("New Employee Budget", "COMPLETED", "Decide on a new employee bonus budget " 
//					+ "for the year and figure out who will be promoted");
//			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
//					+ "been damaged due to the hurricane in the region. This needs to be reconstructed");
//			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the "
//					+ "security needs to be improved and proper security team needs to be hired for "
//					+ "implementation");
//			
//			pro1.addEmployee(emp1);
//			pro1.addEmployee(emp2);
//			pro2.addEmployee(emp3);
//			pro3.addEmployee(emp1);
//			pro4.addEmployee(emp1);
//			pro4.addEmployee(emp3);
//			
//			
//			emp1.setTheProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setTheProjects(Arrays.asList(pro1));
//			emp3.setTheProjects(Arrays.asList(pro2, pro4));
//			
//			empRepo.save(emp1);
//			empRepo.save(emp2);
//			empRepo.save(emp3);
//			empRepo.save(emp4);
//			empRepo.save(emp5);
//			empRepo.save(emp6);
//			empRepo.save(emp7);
//			empRepo.save(emp8);
//			empRepo.save(emp9);
//			
//			proRepo.save(pro1);
//			proRepo.save(pro2);
//			proRepo.save(pro3);
//			proRepo.save(pro4);
//			
//		};
	//}

}
