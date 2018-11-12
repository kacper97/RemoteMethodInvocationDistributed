/*
Filename: RMIClient.java
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
Class name: RMIClient
Comment: The RMI client.
*/

public class RMIClient extends JFrame {

static String message = "blank";
static int x;
static int y;

// The HelloWorld object "obj" is the identifier that is
// used to refer to the remote object that implements
// the HelloWorld interface.

static RMI obj = null;

public RMIClient(){
    // Window
    setTitle("Client");
    setSize(400, 500);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    JPanel panel = new JPanel();
    getContentPane().add(panel, BorderLayout.CENTER);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
    
    /*
     * Buttons for Calculator
     */
    
    JButton buttonZero = new JButton("0");
    panel.add(buttonZero);
    
    JButton buttonAdd = new JButton("+");
    panel.add(buttonAdd);
    
    JButton btnMult = new JButton("*");
    panel.add(btnMult);
    
    JButton buttonDiv = new JButton("/");
    panel.add(buttonDiv);
    
    JButton buttonSub = new JButton("-");
    panel.add(buttonSub);
    
    JButton buttonOne = new JButton("1");
    panel.add(buttonOne);

    JButton buttonTwo = new JButton("2");
    panel.add(buttonTwo);
    
    JButton buttonThree = new JButton("3");
    panel.add(buttonThree);
    
    JButton buttonFour = new JButton("4");
    panel.add(buttonFour);
    
    JButton buttonFive = new JButton("5");
    panel.add(buttonFive);
    
    JButton buttonSix = new JButton("6");
    panel.add(buttonSix);
    
    JButton buttonSeven = new JButton("7");
    panel.add(buttonSeven);
    
    JButton buttonEight = new JButton("8");
    panel.add(buttonEight);
    
    JButton buttonNine = new JButton("9");
    panel.add(buttonNine);

    
    setVisible(true);
}// Showing the frame


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
