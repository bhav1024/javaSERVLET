package com.cognizant.annotation;

import java.lang.annotation.Annotation;

public class CognizantTypeProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//using reflection API
		Class<MyClass>classData=MyClass.class;
		Annotation annotations[]=classData.getAnnotations();
		
		for(Annotation annotation:annotations){
			if(annotation instanceof CognizantType){
				System.out.println("considered this class as special class");
			}
			if(annotation instanceof CognizantTable){
				System.out.println("Table name: "+ ((CognizantTable)annotation).tableName());
			}
		}
		
	}

}
