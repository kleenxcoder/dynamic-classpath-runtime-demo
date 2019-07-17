package com.example.classpath.dynamicclasspathruntimedemo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.OverloadedClass;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DynamicClasspathRuntimeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicClasspathRuntimeDemoApplication.class, args);
		log.debug("*************************************************************");
		log.debug("*                                                           *");
		log.debug("*          DynamicClasspathRuntimeDemoApplication           *");
		log.debug("*                                                           *");
		log.debug("*************************************************************");
		log.debug("args=" + Arrays.deepToString(args));
		OverloadedClass overloadedClass = new OverloadedClass(DynamicClasspathRuntimeDemoApplication.class); 
	}

}
