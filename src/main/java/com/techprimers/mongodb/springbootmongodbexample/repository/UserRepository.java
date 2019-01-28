package com.techprimers.mongodb.springbootmongodbexample.repository;

import com.techprimers.mongodb.springbootmongodbexample.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<Users, Integer> {


    List<Users> findByNameStartingWith(String a);

    @Query("{ 'name' : { $regex: ?0 } }")
    List<Users> findByName(String a);
}
