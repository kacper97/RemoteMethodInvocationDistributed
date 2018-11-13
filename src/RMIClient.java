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
int x;
int y;
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
	
	//Text field
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(0, 0, 282, 85);
    frame.getContentPane().add(scrollPane);
    
    view = new JTextField();
    view.setEditable(false);
    view.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
    scrollPane.setViewportView(view);
    view.setColumns(10);

    
    //Buttons Set up
    
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
    buttonOne.addActionListener(e -> x=1);
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
    
    //Numeric buttons Action listener

    
	buttonOne.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed One");
    		view.setText("1");
    			x = 1;
    			y = 1;
		}
	});
	
	buttonTwo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Two");
    		view.setText("2");
    			x = 2;
    			y = 2;
		}
	});
	
	buttonThree.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Three");
    		view.setText("3");
    			x = 3;
    			y = 3; 
		}
	});
	
	buttonFour.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Four");
    		view.setText("4");
    			x = 4;
    			y = 4;
		}
	});
	
	buttonFive.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Five");
    		view.setText("5");
    			x = 5;
    			y = 5; 
		}
	});
	
	buttonSix.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Six");
    		view.setText("6");
    			x = 6;
    			y = 6; 
		}
	});
	
	buttonSeven.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Seven");
    		view.setText("7");
    			x = 7;
    			y = 7; 
		}
	});
	
	buttonEight.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Eight");
    		view.setText("8");
    			x = 8;
    			y = 8; 
		}
	});
	
	buttonNine.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Nine");
    		view.setText("9");
    			x = 9;
    			y = 9; 
		}
	});
	
	buttonZero.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Zero");
    		view.setText("0");
    			x = 0;
    			y = 0;
		}
	});
	
	//Submit action listener
	
	btnSubmit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Submit");
    		
    		try {
    			obj = (RMI)Naming.lookup("//"
    					+ "localhost"
    					+ "/HelloWorld");
    			message = obj.helloWorld();
    			
    			int sum = obj.addNums(x,y);
    			System.out.println(sum);
    			
    			int mult = obj.multiplyNums(x,y);
    			System.out.println(mult);

    		     
    			int div = obj.divideNums(x, y);
    			System.out.println(div);
    			
    			
    			int sub = obj.subNums(x,y);
    			System.out.println(sub);
    	
    		}
    		catch (Exception ex) {
    			System.out.println("HelloWorldClient exception: "
    					+ ex.getMessage());
    			ex.printStackTrace();
    		}
    			
		}
	});
	
	// Action listeners for operands
	
	
	buttonMult.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Multiply");
    		view.setText("*");
		}
	});
	
	buttonDiv.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Div");
    		view.setText("/");
		}
	});
	
	buttonAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Add");
    		view.setText("+");
		}
	});
	
	buttonSub.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Subtrack");
    		view.setText("-");
		}
	});
	

}

	public static void main(String args[]){	
		 new RMIClient();
	}
}