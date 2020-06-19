package com.damon.pma.dto;

public interface EmployeeProject {
	
	
	
	//need to have the property names begin with get for spring data
	public String getFirstName();
	public String getLastName();
	public int getProjectCount();

}
