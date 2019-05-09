import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Reg2 extends JFrame
{
	JButton B,B1;
	JLabel L;
	Reg2()
	{
		setLayout(new BorderLayout(1,1));
		L = new JLabel("DO YOU WANT T0O FILL THE FORM ?");
		add(L);
		B1 = new JButton("NO");
		add(B1,BorderLayout.WEST);
		B = new JButton("YES");
		add(B,BorderLayout.EAST);
		B.addActionListener(new handeler());
		B1.addActionListener(new handeler());
		setSize(350,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public class handeler implements ActionListener
	{
		public void actionPerformed(ActionEvent ac)
		{
			if (ac.getSource() == B)
			{
				ac.getActionCommand();
				dispose();
				Reg1 r1 =new Reg1();
				
				
			}
			else if (ac.getSource() == B1)
			    {
				   ac.getActionCommand();
				   System.exit(1);
				   
				}
		}	
	}
}
class Reg1 extends JFrame
{

JButton b1,b2,b3 ;
JRadioButton Rb1,Rb2;
JComboBox<String> cb1;
JCheckBox ch1,ch2;
JLabel  label,label1,label2,label3,label4,label5;
 JTextField text1,text3,text4 ;
public static JTextField text2;
ButtonGroup group,group1;

private static final String[] names = {"PUNJAB", "SINDH", "BALOCHISTAN", "KPK","GILGITBALTISTAN"};
	
	Reg1()
	{
		
		super("REGISTERATION FORM");
		setLayout(new FlowLayout());
		label1 = new JLabel("NAME");
		label1.setBounds(0,100,50,50);
		add(label1);
		
		text2 = new JTextField (20);
		add(text2);
		
		label2 = new JLabel("ADDRESS");
		label2.setBounds(0,80,50,50);
		add(label2);
		
		text4 = new JTextField (30);
		add(text4);
		label3 = new JLabel("Gender");
		label3.setBounds(0,60,50,50);
		add(label3);
		
		
		group=  new ButtonGroup();
		Rb1 = new JRadioButton("Male",true);
		add(Rb1);
		group.add(Rb1);
		Rb2 = new JRadioButton("Female",false);
		add(Rb2);
		group.add(Rb2);
		label4 = new JLabel("Martail Status");
		label4.setBounds(0,40,50,50);
		add(label4);
		group1= new ButtonGroup();
		ch1 = new JCheckBox("Single");
		add(ch1);
		group1.add(ch1);
		ch2 = new JCheckBox("Married");
		add(ch2);
		group1.add(ch2);
		label5 = new JLabel("PROVINCE");
		label5.setBounds(0,20,40,50);
		cb1 = new JComboBox<String>(names); 
		add(label5);
		cb1.setMaximumRowCount(5);
		add(cb1);
		b1 = new JButton("SUBMIT");
		add(b1);
		b2 = new JButton("CANCEL");
		add(b2);
		text2.addActionListener(new button());
		text4.addActionListener(new button());
		b1.addActionListener(new button());
		b2.addActionListener(new button());
//Rb1.addActionListener(new txt());
//Rb2.addActionListener(new txt());
		cb1.addActionListener(new button());
		ch2.addActionListener(new button());
		cb1.addActionListener(new button());
		b1.addActionListener(new button());
        b2.addActionListener(new button());
		
		setSize(500,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public class button implements ActionListener
	{
	  public void actionPerformed(ActionEvent e) 
     {
		
	if (e.getSource() == b1)
         {
			 	if (text2.getText().equals("") ||  text4.getText().equals("") || b1.getText().equals("") || b2.getText().equals("") /*|| group.getText().equals("") Rb1.getText().equals("") || Rb2.getText().equals("") || cb1.getText().equals("") */|| ch1.getText().equals("") || ch2.getText().equals(""))
         {
			 JOptionPane.showMessageDialog(null, "something is missing ...Failed!","",JOptionPane.ERROR_MESSAGE);
			
         }
         else   
       {
		   e.getActionCommand();
			dispose();
		confrmationWindow c= new confrmationWindow();
       }
			
			
         }
         else if (e.getSource() == b2)
       {
		   e.getActionCommand();
		   System.exit(1);
		   
       }
	   
	}
    }
		
}

class confrmationWindow extends JFrame
{
	JButton B,B1;
	JLabel L;
	confrmationWindow()
	{
		setLayout(new BorderLayout(1,1));
		L = new JLabel("YOUR FORM HAS BEEN SUCCESSFULLY SUBMITTED");
		add(L);
		B1 = new JButton("Cancel");
		add(B1,BorderLayout.WEST);
		B = new JButton("save");
		add(B,BorderLayout.EAST);
		B.addActionListener(new otherFrame());
		B1.addActionListener(new otherFrame());
		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class otherFrame implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			if (a.getSource() == B)
			{
				a.getActionCommand();
				dispose();
				
				FileWriter fw;
				BufferedWriter bw;
				try{
				fw = new FileWriter(""+Reg1.text2+".txt");
				bw = new BufferedWriter(fw);
				}
				catch(IOException e)
				{
					System.out.println("");
				}
			}
			else if (a.getSource() == B1)
			    {
				   a.getActionCommand();
				   System.exit(1);
				   
				}
		}	
	}
	
	
}
public class Reg
{
		public static void main(String []args)
			{
				Reg2 r =new Reg2();
				
				
			}
}