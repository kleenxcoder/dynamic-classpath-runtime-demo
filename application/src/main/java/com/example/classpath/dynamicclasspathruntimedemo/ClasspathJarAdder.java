package com.example.classpath.dynamicclasspathruntimedemo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClasspathJarAdder {
	
    public void addJarToClasspath(File jar) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException {

    	log.debug("adding File " + jar.toString());
    	// Get the ClassLoader class 
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class<?> clazz = cl.getClass();
        
        // Get the protected addURL method from the parent URLClassLoader class
        Method method = clazz.getSuperclass().getDeclaredMethod("addURL", new Class[] {URL.class});
        
        // Run projected addURL method to add JAR to classpath
        method.setAccessible(true);
        method.invoke(cl, new Object[] {jar.toURI().toURL()});
    }
}