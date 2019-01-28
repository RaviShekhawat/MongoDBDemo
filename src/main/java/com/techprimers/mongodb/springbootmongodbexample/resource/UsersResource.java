package com.techprimers.mongodb.springbootmongodbexample.resource;

import com.mongodb.MongoClient;
import com.techprimers.mongodb.springbootmongodbexample.document.Users;
import com.techprimers.mongodb.springbootmongodbexample.repository.UserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UsersResource {

    private UserRepository userRepository;

    private MongoTemplate mongoTemplate =
            new MongoTemplate(new MongoClient("localhost"),"db");

    public UsersResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/createuser")
    public HttpStatus createUser(@Valid @RequestBody Users user) {
        userRepository.save(user);
        return HttpStatus.CREATED;
    }

    @GetMapping("/getallusers")
    public List<Users> getAll() {

        return userRepository.findAll();
    }

    @PostMapping("/deleteuser")
    public void deleteUser(@RequestParam (value = "userid")Integer id) {
        userRepository.delete(id);
    }

    @GetMapping("/searchmatchingusers")
    public List specificUsers(@RequestParam (value = "pattern")String pattern) {

        /*Query query = new Query();
        query.addCriteria(Criteria.where("name").is("Ravi"));
        List<Users> users =  mongoTemplate.find(query,Users.class);*/

        return userRepository.findByName(pattern);
    }


}
