package Starter;

import Frontend.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Starter {
public static void main(String[]args)
{
	  JFrame frame = new JFrame("Student GUI");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400,300);
      JPanel panel1 = new JPanel();
      panel1.setLayout( new FlowLayout() );
      JButton teacher=new JButton("Student");
      JButton student=new JButton("Teacher");
      panel1.add( student);
      panel1.add( teacher);
      student.setBounds(00,00,140, 20);
      teacher.setBounds(00,00,140, 40);
      frame.add(panel1);
      frame.setVisible(true); 
      
      teacher.addActionListener(new ActionListener() {               

      	@Override
      	public void actionPerformed(ActionEvent arg0) {
      	       new StudentmainGUI();                
      	}          
      	});
      student.addActionListener(new ActionListener() {

      	@Override
      	public void actionPerformed(ActionEvent arg0) {
      	       new MastermainGUI();               
      	}          
      	});
}
}
