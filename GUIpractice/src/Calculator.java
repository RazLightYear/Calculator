import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator 
{
public static void main(String[] args) 
{
	calculatorFrame obj=new calculatorFrame();		
}
}

class calculatorFrame extends JFrame implements ActionListener
{
	private JTextField t1;
	private JButton addition,substraction,multiply,divide,equals,Clear,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
	private String s1,s2,s3;	
	
	public calculatorFrame()
	{
		s1=s2=s3="";
				
		t1=new JTextField();
		t1.setEditable(false);
		t1.setBackground(Color.white);
		t1.setPreferredSize(new Dimension(230,40));
		Font f=new Font("Arial",Font.BOLD,20);
		t1.setFont(f);
		add(t1);
		
		
		addition=new JButton("+");
		addition.setFont(f);
		addition.setPreferredSize(new Dimension(50,50));
		add(addition);
		addition.addActionListener(this);
		
		
		b1=new JButton("1");
		b1.setPreferredSize(new Dimension(50,50));
		b1.setFont(f);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("2");
		b2.setPreferredSize(new Dimension(50,50));
		b2.setFont(f);
		add(b2);
		b2.addActionListener(this);
		b3=new JButton("3");
		b3.setPreferredSize(new Dimension(50,50));
		b3.setFont(f);
		add(b3);
		b3.addActionListener(this);
		
		substraction=new JButton("-");
		substraction.setFont(f);
		substraction.setPreferredSize(new Dimension(50,50));
		add(substraction);
		substraction.addActionListener(this);
		
		b4=new JButton("4");
		b4.setPreferredSize(new Dimension(50,50));
		b4.setFont(f);
		add(b4);
		b4.addActionListener(this);
		b5=new JButton("5");
		b5.setPreferredSize(new Dimension(50,50));
		b5.setFont(f);
		add(b5);
		b5.addActionListener(this);
		b6=new JButton("6");
		b6.setPreferredSize(new Dimension(50,50));
		b6.setFont(f);
		add(b6);
		b6.addActionListener(this);
		
		multiply=new JButton("*");
		multiply.setFont(f);
		multiply.setPreferredSize(new Dimension(50,50));
		add(multiply);
		multiply.addActionListener(this);
		
		b7=new JButton("7");
		b7.setPreferredSize(new Dimension(50,50));
		b7.setFont(f);
		add(b7);
		b7.addActionListener(this);
		b8=new JButton("8");
		b8.setPreferredSize(new Dimension(50,50));
		b8.setFont(f);
		add(b8);
		b8.addActionListener(this);
		b9=new JButton("9");
		b9.setPreferredSize(new Dimension(50,50));
		b9.setFont(f);
		add(b9);
		b9.addActionListener(this);
		
		divide=new JButton("/");
		divide.setFont(f);
		divide.setPreferredSize(new Dimension(50,50));
		add(divide);
		divide.addActionListener(this);
		
		b0=new JButton("0");
		b0.setPreferredSize(new Dimension(50,50));
		b0.setFont(f);
		add(b0);
		b0.addActionListener(this);
		
		equals=new JButton("=");
		equals.setPreferredSize(new Dimension(50,50));
		equals.setFont(f);
		add(equals);
		equals.addActionListener(this);
		
		Clear=new JButton("C");
		Clear.setPreferredSize(new Dimension(50,50));
		Clear.setFont(f);
		add(Clear);
		Clear.addActionListener(this);
		
		FlowLayout lay=new FlowLayout();
		lay.setAlignment(FlowLayout.LEFT);
		this.setLayout(lay);
		setVisible(true);
		setSize(280, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		String s=ev.getActionCommand();
		int result = 0;
		
		if(s.charAt(0)>='0' && s.charAt(0)<='9')
			{
			if(!s2.equals("")) // if s2 is still "" that means that no operand was pressed. 
				               // if s2 is not "" anymore that means that an operand was pressed and the rest of the numbers needs to go inside the second number
			{
		 		s3=s3+s;
			}
				
		else
			{
				s1=s1+s;
			}
				
				t1.setText(s1+s2+s3);
			}
		
		else if(s.charAt(0)== '=')
		{
			
			if(s2.equals("+"))
			{
				result=Integer.parseInt(s1)+Integer.parseInt(s3);			
			}
			
			else if(s2.equals("-"))
			{
				result=Integer.parseInt(s1)-Integer.parseInt(s3);			
			}
			
			else if(s2.equals("*"))
			{
				result=Integer.parseInt(s1)*Integer.parseInt(s3);			
			}
			
			else if(s2.equals("/"))
			{
				result=Integer.parseInt(s1)/Integer.parseInt(s3);				
			}
			
			t1.setText(s1+s2+s3+"="+result);
		}
		
		else if(s.charAt(0)== 'C')
		{
			s1=s2=s3="";
			t1.setText("");
		}
		
		else
		{			
			if(s2.equals("") && s3.equals(""))
			{
				s2=s;
			}
			
			else 
			{
			int tmp;
				if (s2.equals("+")) 
					tmp = (Integer.parseInt(s1) + Integer.parseInt(s3)); 
                		else if (s2.equals("-")) 
                			tmp = (Integer.parseInt(s1) - Integer.parseInt(s3)); 
                		else if (s2.equals("/")) 
                			tmp = (Integer.parseInt(s1) / Integer.parseInt(s3)); 
                		else
                			tmp = (Integer.parseInt(s1) * Integer.parseInt(s3)); 
                  
            		s1 = Integer.toString(tmp);               
                	s2 = s;                   
                	s3 = ""; 
             		} 
		}		
	}			
}
