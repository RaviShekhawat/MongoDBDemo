package com.techprimers.mongodb.springbootmongodbexample.document;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Document(collection = "company")
public class Company {

    @Id
    private int id;
    @NotNull
    @Length(max=40)
    @Field("name")
    private String name;
    @NotNull
    @Length(max=15)
    @Field("city")
    private String city;
    @NotNull
    @Length(max=15)
    @Field("country")
    private String country;
    @Field("rating")
    private float avg_rating;
    @DBRef
    @Field("employees")
    private List<Employee> employeeList;

    public Company() {
    }

    public void setAvg_rating(float avg_rating) {
        this.avg_rating = avg_rating;
    }

    public float getAvg_rating() {
        return avg_rating;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", avg_rating=" + avg_rating +
                ", employeeList=" + employeeList +
                '}';
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
