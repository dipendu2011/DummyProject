package com.example.demo.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, UUID> {

	@Query(value = "Select * from Employee where id=:id")
	public Employee findId(UUID id);

	@Query(value = "Select * from Employee")
	public Employee findAllEmployee();

	@Query(value = "SELECT count(name) FROM Employee WHERE name =:name ALLOW FILTERING", allowFiltering = true)
	public int findByName(String name);

}