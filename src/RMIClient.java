/*
Filename: RMIClient.java
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/*
Class name: RMIClient
Comment: The RMI client.
*/

public class RMIClient {

static String message = "blank";
static int x;
static int y;

// The HelloWorld object "obj" is the identifier that is
// used to refer to the remote object that implements
// the HelloWorld interface.

static RMI obj = null;

public static void main(String args[])
{
	try {
		obj = (RMI)Naming.lookup("//"
				+ "localhost"
				+ "/HelloWorld");
		message = obj.helloWorld();
		System.out.println("Please enter two random numbers you want to add up");
		Scanner sc = new Scanner(System.in);
	     int x = sc.nextInt();
	     int y = sc.nextInt();
		
		
		int sum = obj.addNums(x, y);
		System.out.println("Message from the RMI-server was: \""
				+ message + "\n");
		System.out.println(sum);
	}
	catch (Exception e) {
		System.out.println("HelloWorldClient exception: "
				+ e.getMessage());
		e.printStackTrace();
	}
}
}