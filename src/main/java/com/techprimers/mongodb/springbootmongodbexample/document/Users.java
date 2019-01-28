package com.techprimers.mongodb.springbootmongodbexample.document;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Document(collection = "users")
public class Users {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private ObjectId id;
    @NotNull
    @Length(min=4, message="Name should have atleast 4 characters")
    @Field("name")
    private String name;
    @NotNull
    @Length(min=5, message="TeamName should have atleast 5 characters")
    @Field("teamName")
    private String teamName;
    @NotNull
    @Field("salary")
    //@Max(52125, message="TeamName should have atleast 5 characters")
    private Long salary;

    public Users()
    {

    }
    public Users(ObjectId id, String name, String teamName, Long salary) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
