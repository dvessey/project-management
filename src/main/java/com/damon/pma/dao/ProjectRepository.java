package com.damon.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.damon.pma.dto.ChartData;
import com.damon.pma.dto.TimeChartData;
import com.damon.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel="apiprojects", path="apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " +
			"FROM project " +
			"GROUP BY stage")
	public List<ChartData> getProjectStatus();
	
	public Project findByProjectId(long id);
	
	@Query(nativeQuery=true, value="SELECT name as projectName, start_date as startDate, end_date as endDate "
			+ "FROM project")
	public List<TimeChartData> getTimeData();
}
