package com.damon.pma.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO) //this would be used if relying on java code to seed database
	@GeneratedValue(strategy=GenerationType.IDENTITY) //this is used when seeding database with data.sql
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq") //faster than identity hibernate uses batch updates
	private long projectId;
	
	@NotBlank
	private String name;
	@NotBlank
	private String stage; //not started, completed, in progress ect...
	
	private String description;
	
	@NotBlank(message="date cannot be empty")
	private Date startDate;
	@NotBlank(message="date cannot be empty")
	private Date endDate;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_employee", 
				joinColumns=@JoinColumn(name="project_id"), 
				inverseJoinColumns=@JoinColumn(name="employee_id"))
	
	@JsonIgnore
	private List<Employee> employees;
	
	public Project() {
		
	}
	
	public Project(String name, String stage, String description, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addEmployee(Employee emp) {
		if(employees==null) {
			employees = new ArrayList<>();
		}
		employees.add(emp);
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	
}
