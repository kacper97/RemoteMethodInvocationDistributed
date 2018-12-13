package controller;

import java.rmi.Naming;

import model.Calculator;

/*
Classname: CalculatorClient
Filename: CalculatorClient.java
Author: Kacper Woloszyn 
Purpose: The Calculator Client obtains answers from RMI
*/

public class CalculatorClient {
	//communication with RMI and UI answers are obtained here
	public CalculatorClient() {}
	
	private double ans =0.0;
	
	//getAns method which is going to be called from User Interface

	public double getAns(String type, double x, double y) {
		try {
			//Naming.lookup returns an Object that has to be cast to whatever remote interface you're expecting it to be.
			Calculator obj = (Calculator) Naming.lookup("//localhost/Calculator");
			switch(type) {
			//if any of the types below the client knows what to do and what answer to give
			case("add"):
				ans = obj.add(x, y);
				break;
			case("sub"):
				ans =obj.sub(x, y);
				break;
			case("divide"):
				ans =obj.divide(x, y);
				break;
			case("multiply"):
				ans =obj.multiply(x, y);
				break;
			case("power"):
				ans=obj.power(x,y);
				break;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ans;
	}

}
