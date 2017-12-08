package com.ikostan.javatraining;

public class Test {
	
	private static String value = "one";

	//Using switch statement with string evaluation in order to test that Java 7 code works
	public static void main(String[] args) {

		switch(value){
		
		case "one":
			System.out.println("The value is one");
			break;
			
		default:
			System.out.println("The value is not one");
			break;		
		}		
	}
}
