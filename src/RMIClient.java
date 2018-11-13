/*
Filename: RMIClient.java
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
/*
Class name: RMIClient
Comment: The RMI client.
*/

public class RMIClient extends JFrame {

static String message = "blank";
static int x;
static int y;
public JFrame frame;

// The HelloWorld object "obj" is the identifier that is
// used to refer to the remote object that implements
// the HelloWorld interface.

static RMI obj = null;
private JTextField textField;

public RMIClient(){
    // Window
	frame = new JFrame();
	frame.setBounds(100, 100, 300, 450);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
    
    JButton buttonDiv = new JButton("/");
    buttonDiv.setLocation(230, 274);
    buttonDiv.setSize(45,45);
    frame.getContentPane().add(buttonDiv);
    
    JButton buttonAdd = new JButton("+");
    buttonAdd.setLocation(230, 158);
    buttonAdd.setSize(45,45);
    frame.getContentPane().add(buttonAdd);
    
    JButton buttonMult = new JButton("*");
    buttonMult.setLocation(230, 216);
    buttonMult.setSize(45,45);
    frame.getContentPane().add(buttonMult);
    
    JButton buttonSub = new JButton("-");
    buttonSub.setLocation(230, 100);
    buttonSub.setSize(45,45);
    frame.getContentPane().add(buttonSub);
    
    JButton buttonOne = new JButton("1");
    buttonOne.setLocation(12, 216);
    buttonOne.setSize(45,45);
    frame.getContentPane().add(buttonOne);

    JButton buttonTwo = new JButton("2");
    buttonTwo.setLocation(84, 216);
    buttonTwo.setSize(45,45);
    frame.getContentPane().add(buttonTwo);
    
    JButton buttonThree = new JButton("3");
    buttonThree.setLocation(155, 216);
    buttonThree.setSize(45,45);
    frame.getContentPane().add(buttonThree);
    
    JButton buttonFour = new JButton("4");
    buttonFour.setLocation(12, 158);
    buttonFour.setSize(45, 45);
    frame.getContentPane().add(buttonFour);
    
    JButton buttonFive = new JButton("5");
    buttonFive.setSize(45, 45);
    buttonFive.setLocation(84, 158);
    frame.getContentPane().add(buttonFive);
    
    JButton buttonSix = new JButton("6");
    buttonSix.setLocation(155, 158);
    buttonSix.setSize(45,45);
    frame.getContentPane().add(buttonSix);
    
    JButton buttonSeven = new JButton("7");
    buttonSeven.setLocation(12, 100);
    buttonSeven.setSize(45,45);
    frame.getContentPane().add(buttonSeven);
    
    JButton buttonEight = new JButton("8");
    buttonEight.setLocation(84, 100);
    buttonEight.setSize(45,45);
    frame.getContentPane().add(buttonEight);
    
    JButton buttonNine = new JButton("9");
    buttonNine.setLocation(155, 100);
    buttonNine.setSize(45,45);
    frame.getContentPane().add(buttonNine);
    
    JButton buttonZero = new JButton("0");
    buttonZero.setLocation(12, 274);
    buttonZero.setSize(45,45);
    frame.getContentPane().add(buttonZero);
    
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setBounds(0, 345, 282, 58);
    frame.getContentPane().add(btnSubmit);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(0, 0, 282, 85);
    frame.getContentPane().add(scrollPane);
    
    textField = new JTextField();
    scrollPane.setViewportView(textField);
    textField.setColumns(10);

}

	public static void main(String args[]){	
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