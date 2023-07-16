package com.example.stu.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity  // create a Course Table in database.
@Data    // generate a Getter and Setter.

public class Course {
	
	@Id        // it is used to give a primary key to the field.
	@NotNull
	private int cid;  // course id
    
	@NotNull
	private String cname;  //course name
  
	@OneToMany(mappedBy="cor") // it used to mapped the tables like OneToOne.
	@JsonManagedReference // It is used to managed the response given from Postman / Browser.
	private List<Student> std;    // Create a Student Object with List.
}
