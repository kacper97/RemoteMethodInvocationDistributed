package view;

import controller.CalculatorServer;
import model.Calculator;

import javax.swing.*;
import java.awt.*;


/*
Classname: ServerView
Filename: ServerView.java
Author: Kacper Woloszyn 
Purpose: The Server GUI which provides text output for calculator
*/

public class ServerView {
	// Server View will provide a text output for calculator
	final JTextArea area = new JTextArea();
    final JButton calculatorButton;

    public ServerView(){
        JFrame frame = new JFrame("RMI Calculator Server");
        calculatorButton = new JButton("Open New Calculator");

        // when button pressed launch new calculator view
        calculatorButton.addActionListener(e -> new CalculatorView());
        frame.add(new JScrollPane(area), BorderLayout.CENTER);
        frame.add(calculatorButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
    // FORMATNG OF THE INFORMATION THAT IS DISPLAYED IN THE WINDOW
    // SO THAT NEW INFO IS ON A NEW LINE
    public void handleAction(String s){
        area.append(s + '\n');
    }

}