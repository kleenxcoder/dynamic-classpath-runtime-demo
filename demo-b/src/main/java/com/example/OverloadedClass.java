package com.example;

import com.example.demointerface.OverladedClass;

public class OverloadedClass implements OverladedClass {

	private final String PROJECT_NAME = "demo-b";
	private final String OUTPUT = "this class %s is located in project %s";
	
	public OverloadedClass() {
	}
	
	@Override
	public String getInfo() {
		return String.format(OUTPUT, this.getClass().getName(), PROJECT_NAME);
	}

}
