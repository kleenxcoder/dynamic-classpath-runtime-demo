package com.example.demoa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OverloadedClass {

	private final String PROJECT_NAME = "demo-a";
	private final String OUTPUT = "this class &s has been instanced by %s and is located in project %s";
	
	public OverloadedClass(Class<?> clazz) {
		log.debug(String.format(OUTPUT, this.getClass().getName(), clazz.getName(), PROJECT_NAME));
	}

}
