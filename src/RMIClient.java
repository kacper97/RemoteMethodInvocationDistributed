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
private JTextField view = new JTextField();

// The HelloWorld object "obj" is the identifier that is
// used to refer to the remote object that implements
// the HelloWorld interface.

static RMI obj = null;


public RMIClient(){
    // Window
	frame = new JFrame();
	frame.setTitle("CALC");
	frame.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	frame.getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
	frame.getContentPane().setBackground(Color.CYAN);
	frame.setBounds(100, 100, 300, 450);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
    
    JButton buttonDiv = new JButton("/");
    buttonDiv.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonDiv.setBackground(Color.CYAN);
    buttonDiv.setLocation(230, 274);
    buttonDiv.setSize(45,45);
    frame.getContentPane().add(buttonDiv);
    
    JButton buttonAdd = new JButton("+");
    buttonAdd.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonAdd.setBackground(Color.CYAN);
    buttonAdd.setLocation(230, 158);
    buttonAdd.setSize(45,45);
    frame.getContentPane().add(buttonAdd);
    
    JButton buttonMult = new JButton("*");
    buttonMult.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonMult.setBackground(Color.CYAN);
    buttonMult.setLocation(230, 216);
    buttonMult.setSize(45,45);
    frame.getContentPane().add(buttonMult);
    
    JButton buttonSub = new JButton("-");
    buttonSub.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonSub.setBackground(Color.CYAN);
    buttonSub.setLocation(230, 100);
    buttonSub.setSize(45,45);
    frame.getContentPane().add(buttonSub);
    
    JButton buttonOne = new JButton("1");
    buttonOne.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonOne.setBackground(Color.CYAN);
    buttonOne.setLocation(12, 216);
    buttonOne.setSize(45,45);
    frame.getContentPane().add(buttonOne);

    JButton buttonTwo = new JButton("2");
    buttonTwo.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonTwo.setBackground(Color.CYAN);
    buttonTwo.setLocation(84, 216);
    buttonTwo.setSize(45,45);
    frame.getContentPane().add(buttonTwo);
    
    JButton buttonThree = new JButton("3");
    buttonThree.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonThree.setBackground(Color.CYAN);
    buttonThree.setLocation(155, 216);
    buttonThree.setSize(45,45);
    frame.getContentPane().add(buttonThree);
    
    JButton buttonFour = new JButton("4");
    buttonFour.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonFour.setBackground(Color.CYAN);
    buttonFour.setLocation(12, 158);
    buttonFour.setSize(45, 45);
    frame.getContentPane().add(buttonFour);
    
    JButton buttonFive = new JButton("5");
    buttonFive.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonFive.setBackground(Color.CYAN);
    buttonFive.setSize(45, 45);
    buttonFive.setLocation(84, 158);
    frame.getContentPane().add(buttonFive);
    
    JButton buttonSix = new JButton("6");
    buttonSix.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonSix.setBackground(Color.CYAN);
    buttonSix.setLocation(155, 158);
    buttonSix.setSize(45,45);
    frame.getContentPane().add(buttonSix);
    
    JButton buttonSeven = new JButton("7");
    buttonSeven.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonSeven.setBackground(Color.CYAN);
    buttonSeven.setLocation(12, 100);
    buttonSeven.setSize(45,45);
    frame.getContentPane().add(buttonSeven);
    
    JButton buttonEight = new JButton("8");
    buttonEight.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonEight.setBackground(Color.CYAN);
    buttonEight.setLocation(84, 100);
    buttonEight.setSize(45,45);
    frame.getContentPane().add(buttonEight);
    
    JButton buttonNine = new JButton("9");
    buttonNine.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonNine.setBackground(Color.CYAN);
    buttonNine.setLocation(155, 100);
    buttonNine.setSize(45,45);
    frame.getContentPane().add(buttonNine);
    
    JButton buttonZero = new JButton("0");
    buttonZero.setFont(new Font("Stencil", Font.PLAIN, 16));
    buttonZero.setBackground(Color.CYAN);
    buttonZero.setLocation(12, 274);
    buttonZero.setSize(45,45);
    frame.getContentPane().add(buttonZero);
    
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setFont(new Font("Stencil", Font.PLAIN, 16));
    btnSubmit.setBackground(Color.CYAN);
    btnSubmit.setBounds(0, 345, 282, 58);
    frame.getContentPane().add(btnSubmit);
    
    JScrollPane scrollPane = new JScrollPane(view);
    scrollPane.setBounds(0, 0, 282, 85);
    frame.getContentPane().add(scrollPane);
    
    view = new JTextField();
    view.setEditable(false);
    view.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
    scrollPane.setViewportView(view);
    view.setColumns(10);

}

	public static void main(String args[]){	
		 new RMIClient();
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
		
		System.out.println("Please enter two random numbers you want to multiply up");
	     int x1 = sc.nextInt();
	     int y1 = sc.nextInt();
		
		int mult = obj.multiplyNums(x1, y1);
		System.out.println(mult);
		
		System.out.println("Please enter two random numbers you want to divide up");
	     int x2 = sc.nextInt();
	     int y2 = sc.nextInt();
	     
		int div = obj.divideNums(x2, y2);
		System.out.println(div);
		
		System.out.println("Please enter two random numbers you want to subtract");
	     int x3 = sc.nextInt();
	     int y3 = sc.nextInt();
	     
		
		int sub = obj.subNums(x3,y3);
		System.out.println(sub);
	}
	catch (Exception e) {
		System.out.println("HelloWorldClient exception: "
				+ e.getMessage());
		e.printStackTrace();
	}
	}
}