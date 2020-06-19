package com.damon.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.damon.pma.dto.EmployeeProject;
import com.damon.pma.entities.Employee;

//this is to point spring data rest's to a new end point to not conflict with /employees from employee entitiy, as plural is the default automatic api endpoint from spring data rest
@RepositoryRestResource(collectionResourceRel="apiemployees", path="apiemployees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

//	@Override
//	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " + 
			"FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
	
	public Employee findByEmail(String value);

	public Employee findByEmployeeId(long id);
	
}
