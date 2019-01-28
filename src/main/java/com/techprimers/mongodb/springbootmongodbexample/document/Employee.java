package com.techprimers.mongodb.springbootmongodbexample.document;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Document(collection = "employee")
public class Employee {

    @Id
    private int id;
    @NotNull
    @Length(max=40)
    @Field("name")
    private String name;
    @NotNull
    @Length(max=15)
    @Field("department")
    private String department;
    @NotBlank
    @Field("salary")
    private Float salary;
    @Field("company")
    private Company company;

    public Employee() {
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
