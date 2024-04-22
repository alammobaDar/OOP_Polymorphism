package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame implements ActionListener{
	
	String[] Array= {"Rectangle", "Circle", "Triangle"}; 
	
	
	JFrame frame = new JFrame();
	JPanel mainPanel, inputPanel, answerPanel, formulaPanel;
	JComboBox shapes = new JComboBox(Array);
	JButton button = new JButton("Calculate");
	JTextField textfield1, textfield2;
	JLabel solvefor = new JLabel("Solve for:");
	JLabel Title, Formula, shapeImage, Answer;
	
	
	MainFrame() {
	
		frame.setSize(800, 550);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		mainPanel = new JPanel(null);
		mainPanel.setBounds(0, 0 , 350, 250);
		mainPanel.setBackground(Color.gray);
		
		inputPanel = new JPanel(null);
		inputPanel.setBounds(350, 0, 450, 250);
		inputPanel.setBackground(Color.LIGHT_GRAY);
		
		formulaPanel = new JPanel(null);
		formulaPanel.setBounds(0, 250, 350, 300);
		formulaPanel.setBackground(Color.white);
		
		answerPanel = new JPanel(null);
		answerPanel.setBounds(350, 250, 450, 300);
		answerPanel.setBackground(Color.cyan);
		
		shapes.setFont(new Font("Times New Roman", Font.PLAIN,22));
		shapes.setBounds(50, 120, 150, 30);
		shapes.addActionListener(this);
		
		Title = new JLabel("Area Calculator");
		Title.setFont(new Font("Poppins", Font.BOLD, 40));
		Title.setBounds(20, 20, 350, 50);
		
		Formula = new JLabel("A = wl");
		Formula.setFont(new Font("Times New Roman", Font.BOLD, 65));
		Formula.setBounds(50, 10, 350, 50);
		Formula.setForeground(Color.black);
		
		solvefor.setFont(new Font("Poppins", Font.BOLD, 15));
		solvefor.setBounds(10, 90, 100, 30);
		
		Answer = new JLabel();
		Answer.setBounds(20, 40, 400, 250);
		Answer.setFont(new Font("Times New Roman", Font.ITALIC,25));
		
		button.setBounds(300, 150, 100, 35);
		button.addActionListener(this);
		
		
		textfield1 = new JTextField();
		textfield2 = new JTextField();
		
		mainPanel.add(shapes);
		mainPanel.add(Title);
		mainPanel.add(solvefor);
		formulaPanel.add(Formula);
		inputPanel.add(textfield1);
		inputPanel.add(textfield2);
		inputPanel.add(button);
		answerPanel.add(Answer);
		
	
		
		frame.add(mainPanel);
		frame.add(formulaPanel);
		frame.add(inputPanel);
		frame.add(answerPanel);
		frame.setVisible(true); 
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {

		textfield1.setFont(new Font("Impact", Font.PLAIN,20));
		textfield2.setFont(new Font("Impact", Font.PLAIN,20));	
		textfield1.setBounds(20, 50, 350, 30);
		textfield2.setBounds(20, 105, 350, 30);
		
		if(e.getSource()==shapes) {
			
			
			if(shapes.getSelectedItem().equals("Rectangle")) {
				Formula.setText("A = wl");
				
			
				textfield1.setText("Enter Length");
				textfield2.setText("Enter Width");
				textfield2.setVisible(true);
			}
			if(shapes.getSelectedItem().equals("Circle")) {
				Formula.setText("A = πr^2");
				
				textfield1.setText("Enter Radius");
				textfield2.setText("0");
				textfield2.setVisible(false);
				
			}
			if(shapes.getSelectedItem().equals("Triangle")) {
				Formula.setText("A = hb/2");
				textfield2.setVisible(true);	
				textfield1.setText("Enter Base");
				textfield2.setText("Enter Height");
				
						
			}
		}
		
		try {
			if (e.getSource() == button) {
				double inputtedNumber1 = Double.valueOf(textfield1.getText());
				double inputtedNumber2 = Double.valueOf(textfield2.getText());
				
				
				Circle circle = new Circle(inputtedNumber1);
				Rectangle rectangle = new Rectangle(inputtedNumber1,inputtedNumber2);
				Triangle triangle = new Triangle(inputtedNumber1,inputtedNumber2);
				
				
				if(shapes.getSelectedItem().equals("Rectangle")) {
					Answer.setText("The Area of Rectangle is " + rectangle.calculateArea());
				}
				
				else if(shapes.getSelectedItem().equals("Circle")) {
					Answer.setText("The Area of Circle is " + circle.calculateArea());
				
				}	
				else if(shapes.getSelectedItem().equals("Triangle")) {		
					Answer.setText("The Area of Triangle is " + triangle.calculateArea());
				}
				
			}
		
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "Wrong Input");
			System.out.println("Exception" + e1);
		}
	}

}
