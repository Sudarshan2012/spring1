package com.example.stu.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.example.stu.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // it is used to generate Getter and Setter.
@AllArgsConstructor   // Generate No Argument Constructor.
@NoArgsConstructor    // Generate Parameterized Constructor.
public class StudentDto { // StudentDto Class.   
	
     @Id
	//@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dtosid;
    
	//@NotNull
	//@Size(min = 1, max = 15, message="First name Should not be null" )
	private String dtofname;
	
	//@NotNull
	//@Size(min = 1, max = 15, message="Last name Should not be null" )
	private String dtolname;
	
	//@NotNull
	//@Size(min=10)
	//@Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
	private String dtomobile;
	
	@Email
	private String dtoemail;
	
	//@NotNull
	//@Size(min=1, message="Address Should be 50 words")
	private String dtoaddress;
	
	@ManyToOne
	private Course cor;


}
