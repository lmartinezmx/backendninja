package com.enapsys.service;

import java.util.List;

import com.enapsys.entity.Course;
import com.enapsys.model.CourseModel;

public interface CourseService {
	
	public abstract List<CourseModel> listAllCourses();
	public abstract Course addCouse(CourseModel courseModel);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(Course course);

}
