package com.example.stu.converter;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


import com.example.stu.dto.StudentDto;
import com.example.stu.entity.Student;



@Component    // it is used to provide the connection to use the @Autowired the files easily in file.
public class StudentConverter {
	
	// This Method is created to convert Entity Class into Dto class.
	public StudentDto entityToDto(Student std)
	{
		StudentDto dto=new StudentDto(); // create a StudentDto object.
		dto.setDtosid(std.getSid());  // set fields.
		dto.setDtofname(std.getFname());
		dto.setDtolname(std.getLname());
		dto.setDtomobile(std.getMobile());
		dto.setDtoemail(std.getEmail());
		dto.setDtoaddress(std.getAddress());
		dto.setCor(std.getCor());
		return dto; // return dto object.
	 	
	}
	
	// This Method is created to convert List of Entity Class into List of Dto class.
	public List<StudentDto> entityToDto(List<Student> std)
	{
		return std.stream().map(x-> entityToDto(x)).collect(Collectors.toList()); // list of object are converted .
	}
	
	// This Method is created to convert Dto Class into Entity class.
	public Student dtoToEntity(StudentDto dto)
	{
		Student emp=new Student(); // create a Student Class Object.
		emp.setSid(dto.getDtosid()); // set fields.
		emp.setFname(dto.getDtofname());
		emp.setLname(dto.getDtolname());
		emp.setMobile(dto.getDtomobile());
		emp.setEmail(dto.getDtoemail());
		emp.setAddress(dto.getDtoaddress());
		emp.setCor(dto.getCor());
		return emp; // return emp object.
	}
	
	// This Method is created to convert List of Dto Class into List of Entity class.
	public List<Student> dtoToEntity(List<StudentDto> dto)
	{
		return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList()); // list of object are concerted.
	}

}
