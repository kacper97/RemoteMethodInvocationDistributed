/*
Filename: RMIServer.java
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

/*
Classname: RMIServer
Purpose: The RMI server.
*/

public class RMIServer extends UnicastRemoteObject
	implements RMI {
	
	public RMIServer() throws RemoteException {
		super();
	}

	public String helloWorld() {
		System.out.println("Invocation to helloWorld was succesful!");
		return "Hello World from RMI server!";
	}
	
	@Override
	public int addNums(int x, int y) throws RemoteException {
		System.out.println("Add Nums bound in registry");
		int sum = x + y;
		return sum;
	}
	
	@Override
	public int subNums(int x, int y) throws RemoteException {
		System.out.println("sub Nums bound in registry");
		int sub = x - y;
		return sub;
	}

	@Override
	public int multiplyNums(int x, int y) throws RemoteException {
		System.out.println("Mult Nums bound in registry");
		int mult = x*y ;
		return mult;
	}

	@Override
	public int divideNums(int x, int y) throws RemoteException {
		System.out.println("Div Nums bound in registry");
		int div = x/y;
		return div;
	}

	public static void main(String args[]) {
		try {

			// Create an object of the HelloWorldServer class.
		
			RMIServer obj = new RMIServer();
			
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