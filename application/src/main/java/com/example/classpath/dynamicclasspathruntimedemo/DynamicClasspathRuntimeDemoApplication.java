package com.example.classpath.dynamicclasspathruntimedemo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demointerface.OverladedClass;

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
		
		File jarFile = new File(".\\src\\main\\resources\\demo-a-0.0.1-SNAPSHOT.jar");
//		File jarFile = new File(".\\src\\main\\resources\\demo-b-0.0.1-SNAPSHOT.jar");
		
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		
		ClasspathJarAdder jarAdder = new ClasspathJarAdder();
		try {
			jarAdder.addJarToClasspath(jarFile);
			
			log.debug("");
			
			Class<?> clazz = Class.forName("com.example.OverloadedClass");
			log.debug("Class.forName");
			log.debug("toString() " + clazz.toString());
			
			log.debug("");
			
			clazz = ClassLoader.getSystemClassLoader().loadClass("com.example.OverloadedClass");
			log.debug("ClassLoader.getSystemClassLoader().loadClass");
			
			String className         = "com.example.OverloadedClass";
			Class someClass          = Class.forName( className );
			Constructor constructor  = (Constructor) someClass.getConstructor();
			Object someInstance      = constructor.newInstance();
			OverladedClass overladedClass = (OverladedClass)someInstance;
			log.debug("toString() " + overladedClass.getInfo());
			
			log.debug("");
			log.debug("success");
		} catch (Exception e) {
			log.error("error", e);
		}
	}

}
