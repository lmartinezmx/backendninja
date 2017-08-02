package com.enapsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.enapsys.converter.CourseConverter;
import com.enapsys.entity.Course;
import com.enapsys.model.CourseModel;
import com.enapsys.repository.CourseJpaRepository;
import com.enapsys.repository.QueryDSLExampleRepo;
import com.enapsys.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("queryDSLExampleRepo")
	private QueryDSLExampleRepo queryDSLExampleRepo;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call : listAllCourses()");
		List<Course> courses = courseJpaRepository.findAll();
		List<CourseModel> courseModel = new ArrayList<>();
		
		for(Course course: courses){
			courseModel.add(courseConverter.entityToModel(course));
		}
		
		//testing QueryDSLExampleRepo
		Course courseResult = queryDSLExampleRepo.findCustom(false);
		LOG.info("Finding custom: "+ courseResult);
		return courseModel;
		//return courseJpaRepository.findAll();
	}

	@Override
	public Course addCouse(CourseModel courseModel) {
		LOG.info("Call : addCouse()"); 
		Course course = courseConverter.modelToEntity(courseModel);
		return courseJpaRepository.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		LOG.info("Call : updateCourse()"); 
		//Course course = courseConverter.modelToEntity(courseModel);
		return courseJpaRepository.save(course);
	}
	
	@Override
	public int removeCourse(int id) {
		LOG.info("Call : removeCourse()"); 
		courseJpaRepository.delete(id);
		return 0;
	}
	

}
