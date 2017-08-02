package com.enapsys.converter;

import org.springframework.stereotype.Component;

import com.enapsys.entity.Course;
import com.enapsys.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	//entity -> model
	public CourseModel entityToModel(Course course){
		CourseModel courseModel = new CourseModel();
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		return courseModel;
	}
	
	//model -> entity
	public Course modelToEntity(CourseModel courseModel){
		Course course = new Course();
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		return course;
	}
	

}
