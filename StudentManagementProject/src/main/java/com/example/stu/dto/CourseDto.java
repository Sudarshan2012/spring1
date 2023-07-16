package com.example.stu.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.example.stu.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data    // it is used to generate Getter and Setter.
@AllArgsConstructor   // Generate No Argument Constructor.
@NoArgsConstructor   // Generate Parameterized Constructor.
public class CourseDto {   // CourseDto Class.
	
	@NotNull
	private int dtocid;
    
	@NotNull
	private String dtocname;
	
	@OneToMany(mappedBy="cor")
	private List<Student> std;

}
