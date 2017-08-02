package com.enapsys.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.enapsys.entity.Course;
import com.enapsys.model.CourseModel;
import com.enapsys.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	private static final String COURSES_VIEW = "courses"; 
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses(){
		LOG.info("Call :" + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel){
		LOG.info("Call :" + "addCourse()" + "---Param: "+courseModel.toString());
		courseService.addCouse(courseModel);
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute("course") Course course){
		LOG.info("Call :" + "updateCourse()" + "---Param: "+course.toString());
		courseService.updateCourse(course);
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping("/removecourse")
	public String removeCourse(@ModelAttribute("course") Course course){
		LOG.info("Call :" + "removeCourse()" + "---Param: "+course.toString());
		courseService.removeCourse(course.getId());
		return "redirect:/courses/listcourses";
	}

}
