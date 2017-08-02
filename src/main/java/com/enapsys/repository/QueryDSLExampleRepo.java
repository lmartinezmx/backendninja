package com.enapsys.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.enapsys.entity.Course;
import com.enapsys.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course findCustom(boolean exists){
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("aaaa"));
		
		if(exists){
			Predicate predicate2 = qCourse.id.eq(1);
			
			predicateBuilder.and(predicate2);
		}else{
			Predicate predicate3 = qCourse.name.endsWith("pring");
			
			predicateBuilder.or(predicate3);
		}
		
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		
		//List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		
		
	}

}
