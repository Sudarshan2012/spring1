package com.example.stu.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.stu.dto.CourseDto;
import com.example.stu.entity.Course;


@Component    // it is used to provide the connection to use the @Autowired the files easily in file.
public class CourseConverter {
	
	// This Method is created to convert Entity Class into Dto class.
		public CourseDto entityToDto(Course cor)
		{
			CourseDto dto=new CourseDto(); // create CourseDto Object.
			dto.setDtocid(cor.getCid()); // set Fields.
			dto.setDtocname(cor.getCname());
			dto.setStd(cor.getStd());
			return dto; // return dto object.
		}
		// This Method is created to convert List of Entity Class into List of Dto class.
		public List<CourseDto> entityToDto(List<Course> cor)
		{
			return cor.stream().map(x-> entityToDto(x)).collect(Collectors.toList()); // convert all objects.
		}
		// This Method is created to convert Dto Class into Entity class.
		public Course dtoToEntity(CourseDto dto)
		{
			Course dpm=new Course(); // create Course Object.
			dpm.setCid(dto.getDtocid()); // set Fields.
			dpm.setCname(dto.getDtocname());
			dpm.setStd(dto.getStd());
			return dpm; // return dpm object.
		}
		// This Method is created to convert List of Dto Class into List of Entity class.
		public List<Course> dtoToEntity(List<CourseDto> dto)
		{
			return dto.stream().map(x-> dtoToEntity(x)).collect(Collectors.toList());  // convert all object .
		}

}
