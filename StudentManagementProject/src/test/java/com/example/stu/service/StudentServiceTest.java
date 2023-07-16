package com.example.stu.service;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;
import java.util.List;
import com.example.stu.dao.StudentRepo;
import com.example.stu.entity.Student;
import com.example.stu.exceptionhandler.NotFoundException;

@SpringBootTest
public class StudentServiceTest {

	@MockBean  StudentRepo studentrepo;
	@MockBean  StudentService service;
	@Test
	public void testAllStudent()
	{
	    Student dto =new Student();
		dto.setSid(1);
		dto.setFname("Sudarshan");
		dto.setLname("Waghmode");
		dto.setMobile("9146984932");
		dto.setEmail("qa@gmail.com");
		dto.setAddress("Pune");
		
		 Student dto1 =new Student();
			dto1.setSid(1);
			dto1.setFname("Sudarshan");
			dto1.setLname("Waghmode");
			dto1.setMobile("9146984932");
			dto1.setEmail("qa@gmail.com");
			dto1.setAddress("Pune");
		
		List<Student> arr=new ArrayList<>();
		arr.add(dto);
		arr.add(dto1);
		
		Mockito.when(this.studentrepo.findAll()).thenReturn(arr);
		//assertThat(this.StudentService.getAllStudent()).isEqualTo(li);
    }
	
	@Test
	public void testAddStudent()
	{
	    Student dto =new Student();
		dto.setSid(1);
		dto.setFname("Sudarshan");
		dto.setLname("Waghmode");
		dto.setMobile("9146984932");
		dto.setEmail("qa@gmail.com");
		dto.setAddress("Pune");
		
		Mockito.when(this.studentrepo.save(dto)).thenReturn(dto);
		//assertThat(this.studentService.addStudent(dto)).isEqualTo(dto);
	}
	
	@Test
	public void testGetById() throws NotFoundException
	{
	    Student dto=new Student();
	    dto.setSid(1);
		dto.setFname("Sudarshan");
		dto.setLname("Waghmode");
		dto.setMobile("9146984932");
		dto.setEmail("qa@gmail.com");
		dto.setAddress("Pune");
		
		
		Mockito.when(this.studentrepo.findById(1)).thenReturn(dto);
		//assertThat(this.studentService.getById(1)).isEqualTo(dto);
	}
	
	@Test
	public void testDelete()
	{
		Student dto=new Student();
		dto.setSid(1);
		dto.setFname("Sudarshan");
		dto.setLname("Waghmode");
		dto.setMobile("9146984932");
		dto.setEmail("qa@gmail.com");
		dto.setAddress("Pune");
		
		Mockito.when(this.studentrepo.findById(1)).thenReturn(dto);
		Mockito.when(this.studentrepo.existsById(dto.getSid())).thenReturn(false);
		assertFalse(this.studentrepo.existsById(dto.getSid()));
	}
	
	@Test
	public void testUpdateStudent()
	{
		Student dto=new Student();
		dto.setSid(1);
		dto.setFname("Sudarshan");
		dto.setLname("Waghmode");
		dto.setMobile("9146984932");
		dto.setEmail("qa@gmail.com");
		dto.setAddress("Pune");
			
		Mockito.when(this.studentrepo.findById(1)).thenReturn(dto);
		dto.setEmail("sudarshan1234@gmail.com");
		Mockito.when(this.studentrepo.save(dto)).thenReturn(dto);
		
		//assertThat(this.studentService.updateStudent(dto, 1)).isEqualTo(dto);
	}
	
}
