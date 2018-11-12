/*
Filename: RMI.java
*/

import java.rmi.Remote;
import java.rmi.RemoteException;

/*

Class name: RMI
Comment: The remote interface.

*/

public interface RMI extends Remote {
	String helloWorld() throws RemoteException;
	int addNums(int num1, int num2) throws RemoteException;
	int subNums(int num1, int num2) throws RemoteException;
	int multiplyNums(int num1, int num2) throws RemoteException;
	int divideNums(int num1, int num2) throws RemoteException;
}