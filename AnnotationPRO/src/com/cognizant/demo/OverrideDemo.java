package com.cognizant.demo;

public class OverrideDemo {
	
	class Super{
		public void x(){
			System.out.println("__super implementation");
		}
	}
	class Sub extends Super{
		@Override
		public void x(){
			System.out.println("__sub implementation");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
