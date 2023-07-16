package com.example.stu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity    // it is used to create a table in Database.
@Data      // it is used to generate getter and setter
@NoArgsConstructor  // it is a no argument or no parameterized constructor.
@AllArgsConstructor  // it is a argument type constructor
public class Student {
	
	@Id     // it is used to give a primary key to the field.
	//@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;   //student id  
    
	//@NotNull
	//@Size(min = 1, max = 15, message="First name Should not be null" )
	private String fname;    //student firstname
	
	//@NotNull
	//@Size(min = 1, max = 15, message="Last name Should not be null" )
	private String lname;    //student lastname
	
	
	//@NotNull
	//@Size(min=10)
	//@Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
	private String mobile;    //student mobile no
	
	@Email
	private String email;    //student email
	
	//@NotNull
	//@Size(min=1, message="Address Should be 50 words")
	private String address;   //student address
	
	@ManyToOne  // it is used to ManyToOne Mapping or join the 2 tables.
	@JsonBackReference // it is used get Reference back from the browser/ Postman.
	private Course cor; // create a Course object.

}
