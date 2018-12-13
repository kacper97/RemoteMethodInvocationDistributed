package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.BoundedRangeModel;

import model.Calculator;
import view.ServerView;

/*
Classname: CalculatorServer
Filename: CalculatorServer.java
Author: Kacper Woloszyn 
Purpose: The Calculator Server handles the method calls to the RMI and creates RMI object
*/
public class CalculatorServer extends UnicastRemoteObject implements Calculator {


static ServerView serverView = new ServerView();
	
public CalculatorServer() throws RemoteException {
	super();
}
// Info is a call to method below
// Method when Add happens, the server obtains x and y and adds them, I display the information
@Override
public double add(double x, double y) throws RemoteException {
	info();
	serverView.handleAction("Add called : " + x + "+ " + y);
	serverView.handleAction("Calculating .........");
	serverView.handleAction("The following  answer is passed to client : " + (x+y));
	return x + y ;
}

//Method when Sub happens, the server obtains x and y and subtracks them, I display the information
@Override
public double sub(double x, double y) throws RemoteException {
	info();
	serverView.handleAction("Sub Called called : " + x + "- " + y);
	serverView.handleAction("Calculating .........");
	serverView.handleAction("The following numbers and operators passed to client : " + (x-y));
	return x- y ;
}

//Method when multiply happens, the server obtains x and y and multiplies them, I display the information
@Override
public double multiply(double x, double y) throws RemoteException {
	info();
	serverView.handleAction("Mult called : " + x + "* " + y);
	serverView.handleAction("Calculating .........");
	serverView.handleAction("The following answer is passed to client : " + (x*y));
	return x*y;
}

//Method when divide happens, the server obtains x and y and divides them, I display the information
@Override
public double divide(double x, double y) throws RemoteException {
	info();
	serverView.handleAction("Div called : " + x + "/ " + y);
	serverView.handleAction("Calculating .........");
	serverView.handleAction("The following answer is passed to client : " + (x/y));
	return x/y;
}

//Method when power happens, the server obtains x and y and x is the number, y being the power, I display the information
@Override
public double power(double x, double y) throws RemoteException {
	info();
	serverView.handleAction("Power called : " + x + "^ " + y );
	serverView.handleAction("Calculating .........");
	serverView.handleAction(" The following answer is passed to client : " + (Math.pow(x,y)));
	return Math.pow(x,y);
}

//After reading specification, the connection details have to be displayed hence this method
public void info() {
	try {
		serverView.handleAction("Client connected at :" +getClientHost());
	}catch(ServerNotActiveException e){
		e.printStackTrace();
	}
}

public static void main(String args[]) {
	try {

		// Create an object of the HelloWorldServer class.
	
		CalculatorServer obj = new CalculatorServer();
		
		// Bind this object instance to the name "HelloServer".
		// Include the following line if rmiregistry was not started on the command line
		 Registry registry = LocateRegistry.createRegistry( 1099 );

		// and replace the Naming.rebind() with the next line
		 registry.rebind( "Calculator", obj );
	
		//Naming.rebind("HelloWorld", obj);
		System.out.println("Calculator bound in registry");
		serverView.handleAction("Calculator is bound in registery");
	}
	catch (Exception e) {
		System.out.println("Calculator error: " + e.getMessage());
		e.printStackTrace();
	}
  }
}

