package com.example.stu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stu.dto.StudentDto;
import com.example.stu.exceptionhandler.NotFoundException;
import com.example.stu.service.StudentService;

@RestController     // it is a Controller to connect with browser/postman.
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/std")
public class StudentController {
	
@Autowired StudentService studentService; // it automatically provide the connection wit StudentService Class.
	
	@GetMapping("/student") // this Mapping used to get All Data from Database.
	public ResponseEntity<List<StudentDto>> getAll() // list of data fetch
	{
		return ResponseEntity.ok(this.studentService.getAllStudent()); // return all Student data.
	}
	
	@GetMapping("/student/{id}") // this Mapping used to get All Data from Database.
	public ResponseEntity<StudentDto> getById(@PathVariable("id") int id) throws NotFoundException // it fetch data from database by using Id and throw the NotFoundException
	{
		return ResponseEntity.ok(this.studentService.getById(id)); // return Data by using Id.
	}
	
	@PostMapping("/addstudent") // This Mapping is used to Insert new Data into the Table 
	public ResponseEntity<StudentDto> addDepartment1(@Valid @RequestBody StudentDto dto)// Check the validation .
	{
		StudentDto dto1=this.studentService.addCourse(dto); // Create a StudentDto Object
		return new ResponseEntity<>(dto1, HttpStatus.CREATED); // give a HttpSatatus on PostMan.
		
	}
	
	@DeleteMapping("/student/{id}") // this Mapping is used to Delete Data From Database Table. by using id.
	public ResponseEntity<String> delete(@PathVariable("id") int id) // convert Parameters in Integer.
	{
		this.studentService.deleteStudent(id); // Delete 
		return ResponseEntity.ok("Course Deleted."); 
	}
	
	@PutMapping("/student/{id}")// this Mapping is used to update the data from table.
	public StudentDto updateCourse(@RequestBody StudentDto dto,@PathVariable("id") int id) // convert data types.
	{
		return this.studentService.updateStudent(dto, id); // return updated Data.
	}
	

}
