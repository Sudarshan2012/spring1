package com.example.stu.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.stu.dao.CourseRepo;
import com.example.stu.entity.Course;
import com.example.stu.entity.Student;
import com.example.stu.exceptionhandler.NotFoundException;

@SpringBootTest
public class CourseServiceTest {
	
	
	@MockBean CourseRepo courserepo;
	@MockBean CourseService service;
	
	@Test
	public void testAllCourse()
	{
		Course cs=new Course();
		cs.setCid(101);
		cs.setCname("Java");
		
		Course cs1=new Course();
		cs1.setCid(102);
		cs1.setCname("Java");
		
		List<Course> arr=new ArrayList<>();
		arr.add(cs);
		arr.add(cs1);
		
		Mockito.when(this.courserepo.findAll()).thenReturn(arr);
		//assertThat(this.courseService.getAllCourse()).isEqualTo(li);
		
	}
	@Test
	public void testAddStudent()
	{
	    Course cs =new Course();
		cs.setCid(101);
		cs.setCname("Java");
		Mockito.when(this.courserepo.save(cs)).thenReturn(cs);
		//assertThat(this.courseService.addCourse(cs)).isEqualTo(cs);
	}
	
	@Test
	public void testGetById() throws NotFoundException
	{
		Course cs =new Course();
		cs.setCid(101);
		cs.setCname("Java");
		Mockito.when(this.courserepo.findById(1)).thenReturn(cs);
		//assertThat(this.studentService.getById(1)).isEqualTo(dto);
	}
	
	@Test
	public void testDelete()
	{
		 Course cs =new Course();
		 cs.setCid(101);
		 cs.setCname("Java");
		
		Mockito.when(this.courserepo.findById(1)).thenReturn(cs);
		Mockito.when(this.courserepo.existsById(cs.getCid())).thenReturn(false);
		assertFalse(this.courserepo.existsById(cs.getCid()));
	}
	
	@Test
	public void testUpdateCourse()
	{
		 Course cs =new Course();
			cs.setCid(101);
			cs.setCname("Java");
		
		Mockito.when(this.courserepo.findById(101)).thenReturn(cs);
		cs.setCname("Abc");
		Mockito.when(this.courserepo.save(cs)).thenReturn(cs);
		
		//assertThat(this.courseService.updateCourse(cs, 101)).isEqualTo(cs);
	}
	
}
