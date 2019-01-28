package com.techprimers.mongodb.springbootmongodbexample.resource;

import com.mongodb.MongoClient;
import com.techprimers.mongodb.springbootmongodbexample.document.Company;
import com.techprimers.mongodb.springbootmongodbexample.document.NextSequenceService;
import com.techprimers.mongodb.springbootmongodbexample.document.Users;
import com.techprimers.mongodb.springbootmongodbexample.repository.CompanyRepository;
import com.techprimers.mongodb.springbootmongodbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CompanyResource {

    @Autowired
    private NextSequenceService nextSequenceService;
    private CompanyRepository companyRepository;

    private MongoTemplate mongoTemplate =
            new MongoTemplate(new MongoClient("localhost"),"db");

    public CompanyResource(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping("/createcompany")
    public void createUser(@RequestBody Company company) {
        company.setId(nextSequenceService.getNextSequence("customSequences"));
        companyRepository.save(company);
    }

    @GetMapping("/getallcompanies")
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @PostMapping("/deletecompany")
    public void createUser(@RequestParam (value = "userid")Integer id) {
        companyRepository.delete(id);
    }

    @GetMapping("/searchmatchingcompanies")
    public List specificUsers(@RequestParam (value = "pattern")String pattern) {

        /*Query query = new Query();
        query.addCriteria(Criteria.where("name").is("Ravi"));
        List<Users> users =  mongoTemplate.find(query,Users.class);*/

        return companyRepository.findByName(pattern);
    }


}
