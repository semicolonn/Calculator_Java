package test;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class Calculator {
	public double temp=0;
	public double tempTwo=0;
	String operator="";
	
	/*
	 * 
	 * CALCULATOR ASSIGNMENT MASHAL UNIVERSITY 2019 / EDUCATUR SHUJA HAFIZ
	 * JAVA SWIGN AND WINDOWS BUILDER
	 * CREATED BY BAHER edrisebaher@gmail.com
	 * CREATED ON 23 OCT 2019
	 * SEMESTER 6TH ADVANCED JAVA CLASS
	 * 
	 * 
	 * github.com/semicolonn
	 * 
	 * */
	
	
	
	private JFrame frame;
	private JTextField calcTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Image icon = Toolkit.getDefaultToolkit().getImage("images/calculator.png");
		frame.setIconImage(icon);    
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		frame.setTitle("Calculator");
		frame.setBounds(100, 100, 292, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false); // HIDE MAXIMIZING OF THE FORM OR JFRAME
		calcTxt = new JTextField();
		calcTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//////////										SET ONLY NUMERIC FOR THE KEYBOARD TYPING
				if(arg0.getKeyChar()>='0' && arg0.getKeyChar()<='9') {
					calcTxt.setEditable(true);
				}
				else {
					calcTxt.setEditable(false);
				}
			}
		});
		calcTxt.getCaret().setVisible(false);
		calcTxt.setCaretColor(Color.white);
		calcTxt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		calcTxt.setBounds(10, 47, 265, 52);
		frame.getContentPane().add(calcTxt);
		calcTxt.setColumns(10);
		
		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String btnOne= "1";
				calcTxt.setText(calcTxt.getText()+btnOne);
							
			}
		});
		btn_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_1.setBounds(10, 237, 45, 43);
		frame.getContentPane().add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String btnTwo= "2";
				calcTxt.setText(calcTxt.getText()+btnTwo);
				

			}
		});
		btn_2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_2.setBounds(65, 237, 45, 43);
		frame.getContentPane().add(btn_2);
		
		JButton btn_plus = new JButton("+");
		btn_plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calcTxt.getText().equals("")) {	
				operator="+";
				temp= Double.valueOf(calcTxt.getText());
				calcTxt.setText("");
				}
			}
		});
		btn_plus.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btn_plus.setBounds(175, 188, 45, 43);
		frame.getContentPane().add(btn_plus);
		
		JButton btn_eq = new JButton("=");
		btn_eq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Operators (Add / Minus / Divid / Multiply
				if(!calcTxt.getText().equals("")) {
				tempTwo=Double.valueOf(calcTxt.getText());
				if(operator.equals("+")) {
					double sum= temp+ tempTwo;
					calcTxt.setText(Double.toString(sum));
				}
				else if(operator.equals("-")) {
					double minus= temp- tempTwo;
					calcTxt.setText(Double.toString(minus));
				}
				else if(operator.equals("*")) {
					double multiply= temp* tempTwo;
					calcTxt.setText(Double.toString(multiply));
				}
				else if(operator.equals("/")) {
					double divid= temp/ tempTwo;
					calcTxt.setText(Double.toString(divid));
				}
				//calcTxt.setBackground(Color.LIGHT_GRAY);
				calcTxt.setFont(new Font("Segoe UI", Font.BOLD, 20));
				
				}
				
			}
		});
		btn_eq.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_eq.setBounds(175, 291, 100, 43);
		frame.getContentPane().add(btn_eq);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				calcTxt.setText("");
				operator="";
				temp=0;
				tempTwo=0;
			}
		});
		btnC.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnC.setBounds(175, 134, 45, 43);
		frame.getContentPane().add(btnC);
		
		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String btnNine= "9";
				calcTxt.setText(calcTxt.getText()+ btnNine);
			}
		});
		btn_9.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_9.setBounds(120, 134, 45, 43);
		frame.getContentPane().add(btn_9);
		
		JButton btn_point = new JButton(".");
		btn_point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(calcTxt.getText().equals("")) {
					
					calcTxt.setText("0"+".");
				}
				else {
				calcTxt.setText(calcTxt.getText()+".");
			
				}
				
				}
		});
		btn_point.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_point.setBounds(120, 291, 45, 43);
		frame.getContentPane().add(btn_point);
		
		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnFour= "4";
				calcTxt.setText(calcTxt.getText()+btnFour);
			}
		});
		btn_4.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_4.setBounds(10, 188, 45, 43);
		frame.getContentPane().add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnFive= "5";
				calcTxt.setText(calcTxt.getText()+btnFive);
			}
		});
		btn_5.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_5.setBounds(65, 188, 45, 43);
		frame.getContentPane().add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String btnSix= "6";
				calcTxt.setText(calcTxt.getText()+btnSix);
				
			}
		});
		btn_6.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_6.setBounds(120, 188, 45, 43);
		frame.getContentPane().add(btn_6);
		
		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String btnEight= "8";
				calcTxt.setText(calcTxt.getText()+btnEight);
			}
		});
		btn_8.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_8.setBounds(65, 134, 45, 43);
		frame.getContentPane().add(btn_8);
		
		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String btnSeven= "7";
				calcTxt.setText(calcTxt.getText()+ btnSeven);
				
			}
		});
		btn_7.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_7.setBounds(10, 134, 45, 43);
		frame.getContentPane().add(btn_7);
		
		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String btnThree= "3";
				calcTxt.setText(calcTxt.getText()+btnThree);
			}
		});
		btn_3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_3.setBounds(120, 237, 45, 43);
		frame.getContentPane().add(btn_3);
		
		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int btnZero= 0;
				calcTxt.setText(calcTxt.getText()+Integer.toString(btnZero));
			}
		});
		btn_0.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_0.setBounds(10, 291, 100, 43);
		frame.getContentPane().add(btn_0);
		
		JButton btn_minus = new JButton("-");
		btn_minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calcTxt.getText().equals("")) {
				operator="-";
				temp= Double.valueOf(calcTxt.getText());
				calcTxt.setText("");
				}
			}
		});
		btn_minus.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_minus.setBounds(230, 188, 45, 43);
		frame.getContentPane().add(btn_minus);
		
		JButton btn_multiply = new JButton("*");
		btn_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calcTxt.getText().equals("")) {
				operator="*";
				temp= Double.valueOf(calcTxt.getText());
				calcTxt.setText("");
				}
			}
		});
		btn_multiply.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_multiply.setBounds(230, 237, 45, 43);
		frame.getContentPane().add(btn_multiply);
		
		JButton btn_divid = new JButton("/");
		btn_divid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!calcTxt.getText().equals("")) {
				operator="/";
				temp= Double.valueOf(calcTxt.getText());
				calcTxt.setText("");
				}
			}
		});
		btn_divid.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_divid.setBounds(175, 237, 45, 43);
		frame.getContentPane().add(btn_divid);
		
		JButton btn_sqrt = new JButton("\u221A");
		btn_sqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!calcTxt.getText().equals("")) {
				double a= Math.sqrt(Double.valueOf(calcTxt.getText()));
				calcTxt.setText(Double.toString(a));
				}
			}
		});
		btn_sqrt.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_sqrt.setBounds(230, 134, 45, 43);
		frame.getContentPane().add(btn_sqrt);
		
		JLabel lblBaher = new JLabel("______baher______");
		lblBaher.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBaher.setBounds(10, 345, 223, 14);
		frame.getContentPane().add(lblBaher);
	}
}

