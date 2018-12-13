package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
Classname: Calculator
Filename: Calculator.java
Author: Kacper Woloszyn 
Purpose: The Calculator Interface of the RMI server.
*/
// Methods used in the Calculator
public interface Calculator extends Remote {
	double add(double x, double y) throws RemoteException;
	double sub(double x, double y) throws RemoteException;
	double multiply(double x, double y) throws RemoteException;
	double divide(double x, double y) throws RemoteException;
	double power(double x, double y) throws RemoteException;
}