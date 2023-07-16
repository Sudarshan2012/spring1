package com.example.stu.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.stu.entity.Course;



public interface CourseRepo  extends JpaRepository<Course,Integer>    // it provide the Crud Operations.
{
	
	public Course findById(int id);   // it is used to fetch the data by Id.

}
