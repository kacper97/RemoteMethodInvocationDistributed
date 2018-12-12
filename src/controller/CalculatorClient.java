package controller;

import java.rmi.Naming;

import model.Calculator;

public class CalculatorClient {
	//communication with RM + response to UI
	public CalculatorClient() {}
	
	private double ans =0.0;
	
	//etAns method which is going to be called from User Interface

	public double getAns(String type, double x, double y) {
		try {
			//Naming.lookup returns an Object that has to be cast to whatever remote interface you're expecting it to be.
			Calculator obj = (Calculator) Naming.lookup("//localhost/Calculator");
			switch(type) {
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
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ans;
	}
}
