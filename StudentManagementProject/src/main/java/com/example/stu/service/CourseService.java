package com.example.stu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.stu.converter.CourseConverter;
import com.example.stu.dao.CourseRepo;
import com.example.stu.dto.CourseDto;
import com.example.stu.dto.StudentDto;
import com.example.stu.entity.Course;
import com.example.stu.entity.Student;
import com.example.stu.exceptionhandler.NotFoundException;

@Component    // it is used to provide the connection to use the @Autowired the files easily in file.
public class CourseService {
	
	@Autowired    // it automatically provide the connection with CourseRepo.
	private CourseRepo courserepo;
	
	@Autowired     // it automatically provide the connection with CourseService.
	private CourseConverter converter;
	
	
	// this method is create to fetch all data from database.
	public List<CourseDto> getAllCourse()
	{
		List<Course> crs=(List<Course>)this.courserepo.findAll();
		return this.converter.entityToDto(crs); 
	}
	
	// this method is created for get Course Data by using Id.
	public CourseDto getById(int id) throws NotFoundException
	{
		Course cs=this.courserepo.findById(id);
		if(cs!=null)
		return this.converter.entityToDto(cs);
		else
			throw new NotFoundException("Course Not Found with id :"+id );
	}
	
	// this method is create for Add the New Course into the database.
	public CourseDto addCourse(CourseDto dto)
	{
		Course cor=this.converter.dtoToEntity(dto);
		Course result=this.courserepo.save(cor);
		return this.converter.entityToDto(result);
	}
	
	
	// this method is used to delete data from table by using Id.
	public String deleteCourse(int id)
	{
		this.courserepo.deleteById(id); // delete the data from the table .
		return "deleted";
	}
	
	// this method is used to Update data from the Table by using Id
	public CourseDto updateCourse(CourseDto dto,int id)
	{
		Course cor=this.courserepo.findById(id);   // Create a Course class Object and fetch the data from the table.
		cor.setCid(dto.getDtocid());              //setCid 	
		cor.setCname(dto.getDtocname());          //setCname
		this.courserepo.save(cor); // save data into the table.
		return this.converter.entityToDto(cor);    // convert entity to dto.// convert entity to dto.
	}

}
