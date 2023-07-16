package com.example.stu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.stu.converter.StudentConverter;
import com.example.stu.dao.StudentRepo;
import com.example.stu.dto.StudentDto;
import com.example.stu.entity.Student;
import com.example.stu.exceptionhandler.NotFoundException;

@Component  // it is used to provide the connection to use the @Autowired the files easily in file.
public class StudentService 
{
	
	@Autowired   // it automatically provide the connection with StudentRepo.
	public StudentRepo studentrepo;
	
	@Autowired   // it automatically provide the connection with StudentConvertor.
	StudentConverter converter; 
	
	// this method is create to fetch all data from database.
	public List<StudentDto> getAllStudent()
	{
		List<Student> std=(List<Student>)this.studentrepo.findAll();  // fetch all data from the data table and store in List variable.
		return this.converter.entityToDto(std);                      // convert entity to dto.
	}
	
	// this method is create for Add the New Student into the database.
	public StudentDto addCourse(StudentDto dto)
	{
		Student std=this.converter.dtoToEntity(dto);   // convert dto to entity
		Student result=this.studentrepo.save(std);     // save into the data table.
		return this.converter.entityToDto(result);	   // convert entity to dto.
	}
	
	// this method is created for get Student Data by using Id.
	public StudentDto getById(int id) throws NotFoundException    // throw the exception.
	{
		Student std=this.studentrepo.findById(id);             // fetch the data from the table by using Id.
		if(std!=null)                                         // if std is not null the condition is true the execute if block.
		{
			return this.converter.entityToDto(std);          // convert entity to dto.
		}
		else
		{
			throw new NotFoundException("Student Not Found with id :"+id );    // it throw the NotFoundException if the condition is false
		}		
	}
	
	// this method is created for delete data from table.
	public void deleteStudent(int id)
	{
		this.studentrepo.deleteById(id);   // delete the data from table by using Id
	}
	
	
	// this method is used to update data from the table by using Id.
	public StudentDto updateStudent(StudentDto dto,int id)
	{
		Student std1=this.studentrepo.findById(id);   // create a Student class object.
		std1.setSid(dto.getDtosid());                 //set Sid.
		std1.setFname(dto.getDtofname());             //set Fname
		std1.setLname(dto.getDtolname());             //set Lname
		std1.setMobile(dto.getDtomobile());           //setMobile
		std1.setEmail(dto.getDtoemail());             //set Email
		std1.setAddress(dto.getDtoaddress());        //setAddress
		this.studentrepo.save(std1);               //Save data into the table.
		return this.converter.entityToDto(std1);   // convert entity to dto.
	}

}
