package com.techprimers.mongodb.springbootmongodbexample.repository;

import com.techprimers.mongodb.springbootmongodbexample.document.Employee;
import com.techprimers.mongodb.springbootmongodbexample.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    @Query("{ 'name' : { $regex: ?0 } }")
    List<Employee> findByName(String pattern);

    List<Employee> findByNameStartingWith(String pattern);
}
