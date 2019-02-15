package com.cognizant.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicInitialization{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass mc=new MyClass();
		mc.x(10,20);
		
		Class<MyClass> classData=MyClass.class; //class data
		//Reflection_api
		try {
			Constructor<MyClass> constructor=classData.getConstructor();
			MyClass mc1=constructor.newInstance();
			
			Method xMethod=classData.getMethod("x",int.class,int.class);
			xMethod.invoke(mc1, new Object[]{30,40});
			
			//alternative
			
		MyClass mc2=(MyClass)Class.forName("com.cognizant.demo.MyClass").newInstance();
		xMethod.invoke(mc2, new Object[]{90,100});
			
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
