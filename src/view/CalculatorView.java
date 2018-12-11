package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Calculator;

public class CalculatorView implements ActionListener {
	

static String message = "blank";
int x;
int y;
public JFrame frame;
private JTextField view = new JTextField();

// The HelloWorld object "obj" is the identifier that is
// used to refer to the remote object that implements
// the HelloWorld interface.

static Calculator obj = null; // will change this to read from Calc client instead 

	// Here I will bring in calculator Ui with action listeners and inputs / displays
	
	public CalculatorView(){
		
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

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}