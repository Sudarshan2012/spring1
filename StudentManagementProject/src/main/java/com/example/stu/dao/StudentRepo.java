package com.example.stu.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.stu.entity.Student;



public interface StudentRepo extends JpaRepository<Student,Integer>   // it provide the Crud Operations.
{

	public Student findById(int id);   // it is used to fetch the data by Id.
}
