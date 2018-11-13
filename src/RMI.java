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
	int addNums(int x, int y) throws RemoteException;
	int subNums(int x, int y) throws RemoteException;
	int multiplyNums(int x, int y) throws RemoteException;
	int divideNums(int x, int y) throws RemoteException;
}