package com.enapsys.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.enapsys.service.ExerciceService;

@Service("exerciceService")
public class ExerciceServiceImpl implements ExerciceService {
	private static final Log LOG = LogFactory.getLog(ExerciceServiceImpl.class);

	@Override
	public String showString() {
		LOG.info("dentro de exercice service impl");
		return "success";
	}
	
}
