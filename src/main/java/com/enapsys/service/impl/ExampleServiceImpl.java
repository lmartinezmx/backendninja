package com.enapsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.enapsys.model.Person;
import com.enapsys.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
			List<Person> people = new ArrayList<>();
			people.add(new Person("Leo", 30));
			people.add(new Person("ana", 25));
			people.add(new Person("rachael", 35));
			people.add(new Person("jan", 20));
			LOG.info("hello from service");
			return people;
	}

}
