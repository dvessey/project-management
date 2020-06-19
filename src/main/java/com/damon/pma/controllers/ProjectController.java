package com.damon.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.damon.pma.dto.TimeChartData;
import com.damon.pma.entities.Employee;
import com.damon.pma.entities.Project;
import com.damon.pma.services.EmployeeService;
import com.damon.pma.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		Iterable<Employee> employees = empService.getAll();
		model.addAttribute("project", aProject); //"project" is binding to ${project} in new-project.html
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		
		proService.save(project);
				
		//use a redirect whenever saving to database to prevent duplicate submissions
		return "redirect:/projects";
	}
	
	@GetMapping("/update")
	public String displayProjectUpdateForm(@RequestParam("id") long id, Model model) {
		Project aProject = proService.findByProjectId(id);
		model.addAttribute("project", aProject);
		return "projects/new-project";
	}
	
	@GetMapping("/delete")
	public String deleteProject(@RequestParam("id") long id, Model model) {
		Project aProject = proService.findByProjectId(id);
		proService.delete(aProject);
		return "redirect:/projects";
	}
	
	@GetMapping("/timelines")
	public String displayProjectTimeLines(Model model) throws JsonProcessingException {
		List<TimeChartData> timelineData = proService.getTimeData();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonTimeLineString = objectMapper.writeValueAsString(timelineData);
		model.addAttribute("projectTimeList", jsonTimeLineString);
		
		return "projects/project-timelines";
	}
}

