package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.CalculatorClient;
import model.Calculator;
import static java.lang.Character.isDigit;

/*
Classname: CalculatorView
Filename: CalculatorView.java
Author: Kacper Woloszyn 
Purpose: The Calculator GUI with stack implementations for correct operation

Comment  : Used the stack lab from Second year to implement a stack calculator and using that in this assignment ( 3 methods at the bottom )
*/

public class CalculatorView implements ActionListener {
//initialization 
int x;
int y;
public JFrame frame;
private JTextField view = new JTextField();
private String output, ans;
private Stack<Double> memory;
private Stack<Character> stack;
private CalculatorClient calc;

//Constructor to build swing ui
	public CalculatorView(){
		calc = new CalculatorClient();
		stack = new Stack<>();
		memory = new Stack<>();
		output = "";
		ans = "";
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
	    //Operators
	    JButton buttonDiv = new JButton("/");
	    buttonDiv.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonDiv.setBackground(Color.CYAN);
	    buttonDiv.setLocation(230, 190);
	    buttonDiv.setSize(45,30);
	    buttonDiv.addActionListener(this);
	    frame.getContentPane().add(buttonDiv);
	    
	    JButton buttonAdd = new JButton("+");
	    buttonAdd.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonAdd.setBackground(Color.CYAN);
	    buttonAdd.setLocation(230, 130);
	    buttonAdd.setSize(45,30);
	    buttonAdd.addActionListener(this);
	    frame.getContentPane().add(buttonAdd);
	    
	    JButton buttonMult = new JButton("*");
	    buttonMult.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonMult.setBackground(Color.CYAN);
	    buttonMult.setLocation(230, 160);
	    buttonMult.setSize(45,30);
	    buttonMult.addActionListener(this);
	    frame.getContentPane().add(buttonMult);
	    
	    JButton buttonSub = new JButton("-");
	    buttonSub.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonSub.setBackground(Color.CYAN);
	    buttonSub.setLocation(230, 100);
	    buttonSub.setSize(45,30);
	    buttonSub.addActionListener(this);
	    frame.getContentPane().add(buttonSub);
	    
	    JButton buttonBracket1 = new JButton("(");
	    buttonBracket1.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonBracket1.setBackground(Color.CYAN);
	    buttonBracket1.setBounds(230, 220, 45, 30);
	    buttonBracket1.addActionListener(this);
	    frame.getContentPane().add(buttonBracket1);
	    
	    JButton buttonBracket2 = new JButton(")");
	    buttonBracket2.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonBracket2.setBackground(Color.CYAN);
	    buttonBracket2.setBounds(230, 250, 45, 30);
	    buttonBracket2.addActionListener(this);
	    frame.getContentPane().add(buttonBracket2);
	    
	    JButton buttonPower = new JButton("^");
	    buttonPower.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonPower.setBackground(Color.CYAN);
	    buttonPower.setBounds(230, 280, 45, 30);
	    buttonPower.addActionListener(this);
	    frame.getContentPane().add(buttonPower);
	    
	    // Numeric
	    
	    JButton buttonOne = new JButton("1");
	    buttonOne.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonOne.setBackground(Color.CYAN);
	    buttonOne.setLocation(12, 216);
	    buttonOne.setSize(45,45);
	    buttonOne.addActionListener(this);
	    frame.getContentPane().add(buttonOne);

	    JButton buttonTwo = new JButton("2");
	    buttonTwo.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonTwo.setBackground(Color.CYAN);
	    buttonTwo.setLocation(84, 216);
	    buttonTwo.setSize(45,45);
	    buttonTwo.addActionListener(this);
	    frame.getContentPane().add(buttonTwo);
	    
	    JButton buttonThree = new JButton("3");
	    buttonThree.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonThree.setBackground(Color.CYAN);
	    buttonThree.setLocation(155, 216);
	    buttonThree.setSize(45,45);
	    buttonThree.addActionListener(this);
	    frame.getContentPane().add(buttonThree);
	    
	    JButton buttonFour = new JButton("4");
	    buttonFour.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonFour.setBackground(Color.CYAN);
	    buttonFour.setLocation(12, 158);
	    buttonFour.setSize(45, 45);
	    buttonFour.addActionListener(this);
	    frame.getContentPane().add(buttonFour);
	    
	    JButton buttonFive = new JButton("5");
	    buttonFive.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonFive.setBackground(Color.CYAN);
	    buttonFive.setSize(45, 45);
	    buttonFive.setLocation(84, 158);
	    buttonFive.addActionListener(this);
	    frame.getContentPane().add(buttonFive);
	    
	    JButton buttonSix = new JButton("6");
	    buttonSix.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonSix.setBackground(Color.CYAN);
	    buttonSix.setLocation(155, 158);
	    buttonSix.setSize(45,45);
	    buttonSix.addActionListener(this);
	    frame.getContentPane().add(buttonSix);
	    
	    JButton buttonSeven = new JButton("7");
	    buttonSeven.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonSeven.setBackground(Color.CYAN);
	    buttonSeven.setLocation(12, 100);
	    buttonSeven.setSize(45,45);
	    buttonSeven.addActionListener(this);
	    frame.getContentPane().add(buttonSeven);
	    
	    JButton buttonEight = new JButton("8");
	    buttonEight.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonEight.setBackground(Color.CYAN);
	    buttonEight.setLocation(84, 100);
	    buttonEight.setSize(45,45);
	    buttonEight.addActionListener(this);
	    frame.getContentPane().add(buttonEight);
	    
	    JButton buttonNine = new JButton("9");
	    buttonNine.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonNine.setBackground(Color.CYAN);
	    buttonNine.setLocation(155, 100);
	    buttonNine.setSize(45,45);
	    buttonNine.addActionListener(this);
	    frame.getContentPane().add(buttonNine);
	    
	    JButton buttonZero = new JButton("0");
	    buttonZero.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonZero.setBackground(Color.CYAN);
	    buttonZero.setLocation(12, 274);
	    buttonZero.setSize(45,45);
	    buttonZero.addActionListener(this);
	    frame.getContentPane().add(buttonZero);
	    
	    //Operational
	    
	    JButton buttonSubmit = new JButton("SUBMIT");
	    buttonSubmit.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonSubmit.setBackground(Color.CYAN);
	    buttonSubmit.setBounds(0, 345, 282, 58);
	    buttonSubmit.addActionListener(this);
	    frame.getContentPane().add(buttonSubmit);
	    
	    JButton buttonDec = new JButton(".");
	    buttonDec.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonDec.setBackground(Color.CYAN);
	    buttonDec.setBounds(230, 310, 45, 30);
	    buttonDec.addActionListener(this);
	    frame.getContentPane().add(buttonDec);
	    
	    JButton buttonClear = new JButton("CLEAR");
	    buttonClear.setFont(new Font("Stencil", Font.PLAIN, 16));
	    buttonClear.setBackground(Color.CYAN);
	    buttonClear.setBounds(84, 274, 117, 45);
	    buttonClear.addActionListener(this);
	    frame.getContentPane().add(buttonClear);

	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		switch(e.getActionCommand()) {
		case("CLEAR"):
			view.setText(""); //if clear is the action obtained make view blank
			break;
		case("SUBMIT"):
			converterInfixToPostfix(view.getText()); //if submit is pressed, pass view text to parse method
        break;
        default: view.setText(view.getText().concat(e.getActionCommand())); //default builds the view
		}
		
	}
	
	   //I need a method to calculate based on the top element of  the stack
		// and a method that parses reverse polish to stack 
		// takes in the calculation string
		private void calculate(String calculation) {
			//clears the momory and answer =null
			memory.clear();
	        ans = "";
	        //keeping the doubles consistent in the program to be x and y
	        double x;
	        double y;
	        //tokenization using space
	        String[] tokens = output.split(" ");
	        for (String currentInput : tokens) {
	        	//if not a number
	            if ((!currentInput.equals("+")) && (!currentInput.equals("-"))
	                    && (!currentInput.equals("*")) && (!currentInput.equals("/"))
	                    && (!currentInput.equals("^"))) {
	                memory.push(Double.parseDouble(currentInput));
	                
	              // else if 2 or more numbers imputed to the calculations , based on the + - / * ^ symbol
	                //nested else if statement, if more than two numbers do this and then if different operators
	            } else if (memory.size() >= 2) {
	                if (currentInput.equals("+")) {
	                    x = memory.pop();
	                    y = memory.pop();
	                    memory.push(calc.getAns("add", x, y));
	                }
	                
	                if (currentInput.equals("-")) {
	                    x = memory.pop();
	                    y = memory.pop();
	                    memory.push(calc.getAns("sub", x, y));
	                }
	                
	                if (currentInput.equals("/")) {
	                    x = memory.pop();
	                    y = memory.pop();
	                    memory.push(calc.getAns("divide", x, y));
	                }
	      
	                if (currentInput.equals("*")) {
	                    x = memory.pop();
	                    y = memory.pop();
	                    memory.push(calc.getAns("multiply", x, y));
	                }
	              
	                if (currentInput.equals("^")) {
	                    x = memory.pop();
	                    y = memory.pop();
	                    memory.push(calc.getAns("power", x, y));
	                }
	            }
	        }
	        view.setText(ans + memory.pop());
		}
		
	//Need a method that converts the textield from infix to postfix for RMI
	//Convert the infix form to postfix using a stack to store operators 
	//then pop them in correct order of precedence
	
	private void converterInfixToPostfix(String s) {
		// for any length of string do this
		for(int i = 0; i< s.length(); i++){
            char characterAtI = s.charAt(i);
            //if a digit and not a operator and no operator is given
            
            if((!isDigit(characterAtI)) && (characterAtI!='.') && (characterAtI!='(') && (characterAtI!=')')){
                char blankSpace = ' ';
                output = output + blankSpace;
            }
            //if operator is given
            
            switch (characterAtI){
            //assign priorities based on the method below
                case '+':
                case '-':
                    priorityOfOperator(characterAtI, 1);
                    break;
                case '*':
                case '/':
                    priorityOfOperator(characterAtI, 2);
                    break;
                    
                    //if power
                case '^':
                	//if stack is not empty then precidence  is 3. 
                	//The condition of being considered more important than someone or something else is precidence
                    while(!stack.isEmpty()){
                        int precidence1 = 3;
                        char topofStack = stack.pop(); // check the top of stack character by poping
                        if (topofStack == '('){
                            stack.push(topofStack); // if bracket is first push 
                            break;
                        }else{
                        	//if not a brackets its priority 2
                            int priority2;
                            if(topofStack == '+' || topofStack == '-') {
                                priority2 = 1;
                            }else {
                                priority2 = 2;
                            }
                            //
                            if(topofStack == '*' || topofStack == '/') {
                                priority2 = 1;
                            }else{
                                priority2 = 2;
                            }
                            //if less than 3 signs/ as precidence is 3
                            if(priority2 < precidence1){
                                stack.push(topofStack);
                                break;
                            }else output = output + topofStack + ' ';
                        }
                    }
                    //if stack is empty push the first operator
                    stack.push(characterAtI);
                    break;
                    //if open bracket
                case '(':
                    stack.push(characterAtI);
                    break;
                    //if closed bracket and stack is not empty  and if there is no opening bracket then break, else print output
                case ')':
                    while(!stack.isEmpty()){
                        char twoBrack = stack.pop();
                        if(twoBrack=='('){
                            break;
                        }else{
                            output = output + " " + twoBrack;
                        }
                    }
                    break;
                    //Default is output is output + the operator
                default:
                    output = output + characterAtI;
                    break;
            }
        }
		// if stack is empty output is output  and operator from stack
        while(!stack.isEmpty()){
            output = output + ' ' + stack.pop();
        }
        System.out.println("Reverse Polish Notation : " + output);
        calculate(output);
	}
	
	//Also I need a method to give operators the priority
	//so if a bracket is added then push it to the top of the stack
	// the method takes in the operator , and which priority it is
	private void priorityOfOperator(char operator, int priority) {
		 while(!stack.isEmpty()){
			 //stack.pop removes and returns the top object of the stack
	            char topofStack = stack.pop();
	            if (topofStack == '('){
	                stack.push(topofStack);
	                break;
	            }else{
	                int priority1;
	                if(topofStack == '+' || topofStack == '-') {
	                    priority1 = 1;
	                }else {
	                    priority1 = 2;
	                }
	                //if + - priority 1 / else priority 1 assigned 2
	                // if +- is less than priority given then push top of stack
	                if(priority1 < priority){
	                    stack.push(topofStack);
	                    break;
	                }else output = output + topofStack + ' ';
	            }
	        }
	        stack.push(operator);
	}
}