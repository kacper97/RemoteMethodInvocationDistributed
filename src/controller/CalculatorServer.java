package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.BoundedRangeModel;

import model.Calculator;

public class CalculatorServer extends UnicastRemoteObject
implements Calculator {

	//maths methods handler

	
public CalculatorServer() throws RemoteException {
	super();
}

public String helloWorld() {
	System.out.println("Invocation to helloWorld was succesful!");
	return "Hello World from RMI server!";
} 	

@Override
public int add(int x, int y) throws RemoteException {
	System.out.println("Add Nums bound in registry");
	return x + y ;
}

@Override
public int sub(int x, int y) throws RemoteException {
	System.out.println("sub Nums bound in registry");
	return x- y ;
}

@Override
public int multiply(int x, int y) throws RemoteException {
	System.out.println("Mult Nums bound in registry");
	return x*y;
}

@Override
public int divide(int x, int y) throws RemoteException {
	System.out.println("Div Nums bound in registry");
	return x/y;
}

@Override
public int power(int x, int y) throws RemoteException {
	System.out.println("Power Bounded in reg");
	return Math.pow(x,y);
}

public static void main(String args[]) {
	try {

		// Create an object of the HelloWorldServer class.
	
		CalculatorServer obj = new CalculatorServer();
		
		// Bind this object instance to the name "HelloServer".
		// Include the following line if rmiregistry was not started on the command line
		 Registry registry = LocateRegistry.createRegistry( 1099 );

		// and replace the Naming.rebind() with the next line
		 registry.rebind( "HelloWorld", obj );
	
		//Naming.rebind("HelloWorld", obj);
		System.out.println("HelloWorld bound in registry");

	}
	catch (Exception e) {
		System.out.println("HelloWorldServer error: " + e.getMessage());
		e.printStackTrace();
	}
  }
}

