package com.example.stu.controller;

import java.util.List;

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

import com.example.stu.dto.CourseDto;
import com.example.stu.exceptionhandler.NotFoundException;
import com.example.stu.service.CourseService;


@RestController    // it is a Controller to connect with browser/postman.
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/cor")
public class CourseController {
	
    @Autowired CourseService courseService;// it automatically provide the connection with CourseService Class.
	
	
	@GetMapping("/course") // this Mapping used to get All Data from Database.
	public ResponseEntity<List<CourseDto>> getAll()
	{
		return ResponseEntity.ok(this.courseService.getAllCourse());
	}
	
	@GetMapping("/course/{id}") // this Mapping used to get All Data from Database.
	public ResponseEntity<CourseDto> getById(@PathVariable("id") int id) throws NotFoundException
	{
		return ResponseEntity.ok(this.courseService.getById(id));
	}
	
	@PostMapping("/course")// This Mapping is used to Insert new Data into the Table 
	public ResponseEntity<CourseDto> addDepartment1(@RequestBody CourseDto dto)
	{
		CourseDto dto1=this.courseService.addCourse(dto);
		return new ResponseEntity<>(dto1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/course/{id}")// this Mapping is used to Delete Data From Database Table. by using id.
	public ResponseEntity<String> delete(@PathVariable("id") int id)
	{
		this.courseService.deleteCourse(id);
		return ResponseEntity.ok("Course Deleted.");
	}
	
	@PutMapping("/course/{id}")// this Mapping is used to update the data from table.
	public CourseDto updateCourse(@RequestBody CourseDto dto,@PathVariable("id") int id)
	{
		return this.courseService.updateCourse(dto, id);
	}
}


