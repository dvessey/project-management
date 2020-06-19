package com.damon.pma.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.damon.pma.entities.Employee;
import com.damon.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		Iterable<Employee> employees = empService.getAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(@Valid Employee employee, Model model, Errors errors) {
		
		if(errors.hasErrors())
			return "employees/new-employee";
		
		empService.save(employee);
		return "redirect:/employees";
	}
	
	//have to use get mapping, in order to use patch, delete ect... instead of 
	//using an <a> tag in the html, you'd have to put that code into a form instead
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {
		Employee aEmployee = empService.findByEmployeeId(id);
		//bind the data in the html form so we can see it in the form
		model.addAttribute("employee", aEmployee);
		return "employees/new-employee";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long id, Model model) {
			Employee aEmployee = empService.findByEmployeeId(id);
			empService.delete(aEmployee);
			return "redirect:/employees";
	}
}
