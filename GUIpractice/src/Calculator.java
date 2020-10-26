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
	// TextField to present the calculations
	private JTextField t1; 
	
	// strings to hold the values and operands
	private String s1,s2,s3;
	
	// An array of buttons
	private JButton [] buttons;
	
	// the buttons names
	private String[] names= {"+","1","2","3","-","4","5","6","*","7","8","9","/","0","=","C"};		
	
	public calculatorFrame()
	{
		s1=s2=s3="";
		Font f=new Font("Arial",Font.BOLD,20);
		buttons=new JButton[names.length];
		
		t1=new JTextField();
		t1.setEditable(false);
		t1.setBackground(Color.white);
		t1.setPreferredSize(new Dimension(230,40));		
		t1.setFont(f);
		add(t1);
		
		for(int i=0;i<names.length;i++)
		{
			buttons[i]=new JButton(names[i]);
			buttons[i].setFont(f);
			buttons[i].setPreferredSize(new Dimension(50,50));
			add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		
		
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
