package model;
/*
Filename: RMI.java
*/

import java.rmi.Remote;
import java.rmi.RemoteException;

/*

Class name: RMI
Comment: The remote interface.

*/

public interface Calculator extends Remote {
	//String helloWorld() throws RemoteException;
	int add(int x, int y) throws RemoteException;
	int sub(int x, int y) throws RemoteException;
	int multiply(int x, int y) throws RemoteException;
	int divide(int x, int y) throws RemoteException;
}