package com.techprimers.mongodb.springbootmongodbexample.resource;

import com.mongodb.MongoClient;
import com.techprimers.mongodb.springbootmongodbexample.document.Company;
import com.techprimers.mongodb.springbootmongodbexample.document.Employee;
import com.techprimers.mongodb.springbootmongodbexample.document.NextSequenceService;
import com.techprimers.mongodb.springbootmongodbexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.xml.ws.http.HTTPException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeResource {

    private EmployeeRepository employeeRepository;
    @Autowired
    private NextSequenceService nextSequenceService;
    private MongoTemplate mongoTemplate =
            new MongoTemplate(new MongoClient("localhost"),"db");

    public EmployeeResource(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/createemployee")
    public ResponseEntity<Employee> createUser(@RequestBody Employee employee) {
        employee.setId(nextSequenceService.getNextSequence("customSequences"));
        Query query = new Query();
        query.addCriteria(Criteria.where("company").is(employee.getCompany()));
        List<Company> companies =  mongoTemplate.find(query,Company.class);
        //companies.stream().map(Company::getName).collect(Collectors.toList());
        System.out.print(companies);
        if(companies.size()==0)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"no company with this name ");
        employeeRepository.save(employee);
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
    }

    @GetMapping("/getallemployees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/deleteemployee")
    public void deleteUser(@RequestParam(value = "employeeid")Integer id) {
        employeeRepository.delete(id);
    }

    @GetMapping("/searchmatchingemployess")
    public List specificUsers(@RequestParam (value = "pattern")String pattern) {

        /*Query query = new Query();
        query.addCriteria(Criteria.where("name").is("Ravi"));
        List<Users> users =  mongoTemplate.find(query,Users.class);*/

        return employeeRepository.findByName(pattern);
    }


}
