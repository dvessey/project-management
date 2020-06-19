insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'John', 'Warton', 'warton@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Mike', 'Lanister', 'lanister@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Steve', 'Reeves', 'Reeves@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Ronald', 'Connor', 'connor@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Jim', 'Salvator', 'Sal@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Peter', 'Henley', 'henley@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Richard', 'Carson', 'carson@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Honor', 'Miles', 'miles@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values(nextval('employee_seq'), 'Tony', 'Roggers', 'roggers@gmail.com');

insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployement');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'New Employee Budget', 'COMPLETED', 'Decide on a new employee bonus budget for the year');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved');

insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Warton' and p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Warton' and p.name = 'New Employee Budget');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Warton' and p.name = 'Office Reconstruction');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Reeves' and p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Warton' and p.name = 'Improve Intranet Security');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Reeves' and p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Henley' and p.name = 'Large Production Deploy');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name = 'Henley' and p.name = 'Improve Intranet Security');