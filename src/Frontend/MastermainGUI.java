package Frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Backend.TeacherOperation; 

public class MastermainGUI{
	public MastermainGUI(){
		new TeacherOperation();
        JFrame frame = new JFrame("Teacher Main Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,100);
        JPanel panel = new JPanel();
        JButton add = new JButton("Add");
        JButton display = new JButton("Display");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete\n");
        panel.add(add); // Components Added using Flow Layout
        panel.add(display);
        panel.add(update);
        panel.add(delete);
        
        
        //Links buttons to the function that are to be performed
        add.addActionListener(new ActionListener() {               

        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        	       Add();                
        	}          
        	});
        update.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        	       Update();                
        	}          
        	});
        delete.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        	       Delete();                
        	}          
        	});
        display.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        	       try{Display1();}
        	       catch(Exception e) {}
        	}          
        	});
        
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
	}
        
	
	    //Add Function
        public static void Add(){    
            JFrame f=new JFrame("ADD Enteries"); 
            //submit button
            JButton b=new JButton("Submit");    
            b.setBounds(90,200,140, 40); 
                
            //back button
            JButton back=new JButton("Back");    
            back.setBounds(10,200,75, 30); 
            
            //enter name label
            JLabel label = new JLabel();
            JLabel label5 = new JLabel();        
            label.setText("Enter Name/ID :");
            label.setBounds(10, 10, 100, 100);
            JLabel label_Marks = new JLabel();        
            label_Marks.setText("Enter Marks :");
            label_Marks.setBounds(10, 83, 100, 100);
            
            //TextField to enter name
            JTextField textfield= new JTextField();
            textfield.setBounds(110, 50, 130, 30);
            
            
            //creating input box for Subject marks
            JTextField textfield1= new JTextField();
            textfield1.setBounds(110, 120, 40, 30);
            JTextField textfield2= new JTextField();
            textfield2.setBounds(170, 120, 40, 30);
            JTextField textfield3= new JTextField();
            textfield3.setBounds(230, 120, 40, 30);
            
            
            //creating subjects marks labels
            JLabel label1 = new JLabel();        
            label1.setText("Subject1");
            label1.setBounds(110, 110, 100, 100);
            JLabel label2 = new JLabel();        
            label2.setText("Subject2");
            label2.setBounds(170, 110, 100, 100);
            JLabel label3 = new JLabel();        
            label3.setText("Subject3");
            label3.setBounds(230, 110, 100, 100);
            
            //add to frame
            f.add(label_Marks);
            f.add(textfield);
            f.add(textfield1);
            f.add(textfield2);
            f.add(textfield3);
            f.add(label);
            f.add(label1);
            f.add(label2);
            f.add(label3);
            f.add(label5);
            f.add(b);
            f.add(back);
            f.setSize(300,300);    
            f.setLayout(null);    
            f.setVisible(true);    
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
            
            //action listener and links the message to the Submit button to be displayed after Submit is clicked
            b.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent arg0) {
                	String id=textfield.getText();
                	int s1=Integer.parseInt(textfield1.getText());
                	int s2=Integer.parseInt(textfield2.getText());
                	int s3=Integer.parseInt(textfield3.getText());
                	boolean value=TeacherOperation.addStudent(id, s1, s2, s3);
                	if(value)
                	label5.setText("Enteries Added");
                	else
                	label5.setText("Enteries Could Not be Added");
                    label5.setBounds(100, 130, 100, 100);
                    textfield.setText("");
                    textfield1.setText("");
                    textfield2.setText("");
                    textfield3.setText("");
                }          
              });
            
          //action listener making this frame not visible
            back.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent arg0) {
              	  f.setVisible(false);
            }          
              });
        }
        
       
           //Update Function
           public void Update(){    
                JFrame f=new JFrame("Update Enteries"); 
                            //submit button
                JButton b=new JButton("Submit");    
                b.setBounds(90,200,140, 40); 
                
                //back button
                JButton back=new JButton("Back");    
                back.setBounds(10,200,75, 30); 
                
                //enter name label
                JLabel label = new JLabel();
                JLabel label5 = new JLabel();
                label.setText("Enter Name/ID :");
                label.setBounds(10, 10, 100, 100);
                
                JLabel label_Marks = new JLabel();
                label_Marks.setText("Enter Marks :");
                label_Marks.setBounds(10, 83, 100, 100);
                
                             //textfield to enter name
                JTextField textfield= new JTextField();
                textfield.setBounds(110, 50, 130, 30);
                
                            //creating input box for Subject marks
                JTextField textfield1= new JTextField();
                textfield1.setBounds(110, 120, 40, 30);
                JTextField textfield2= new JTextField();
                textfield2.setBounds(170, 120, 40, 30);
                JTextField textfield3= new JTextField();
                textfield3.setBounds(230, 120, 40, 30);
                
                
                           //creating subjects marks labels
                JLabel label1 = new JLabel();        
                label1.setText("Subject1");
                label1.setBounds(110, 110, 100, 100);
                JLabel label2 = new JLabel();        
                label2.setText("Subject2");
                label2.setBounds(170, 110, 100, 100);
                JLabel label3 = new JLabel();        
                label3.setText("Subject3");
                label3.setBounds(230, 110, 100, 100);
                
                //add to frame
                f.add(label_Marks);
                f.add(textfield);
                f.add(textfield1);
                f.add(textfield2);
                f.add(textfield3);
                f.add(label);
                f.add(label1);
                f.add(label2);
                f.add(label3);
                f.add(label5);
                f.add(b);   
                f.add(back);
                f.setSize(300,300);    
                f.setLayout(null);    
                f.setVisible(true);    
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
                
              //action listener and links the message to the Submit button to be displayed after Submit is clicked
                b.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                    	String id=textfield.getText();
                    	int s1=Integer.parseInt(textfield1.getText());
                    	int s2=Integer.parseInt(textfield2.getText());
                    	int s3=Integer.parseInt(textfield3.getText());
                    	boolean value=TeacherOperation.updateStudent(id, s1, s2, s3);
                    	if(value)
                    	label5.setText("Enteries Updated");
                    	else
                    	label5.setText("Enteries Not Updated");
                        label5.setBounds(100, 130, 100, 100);
                        textfield.setText("");
                        textfield1.setText("");
                        textfield2.setText("");
                        textfield3.setText("");
                    }          
                  });
                
                back.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                  	  f.setVisible(false);
                }          
                  });
                
                }   
           
           //Delete Function
           public void Delete() {
     		  JFrame f= new JFrame("DELETE ENTRY");
     		  //submit button
     		  JButton b= new JButton("Submit");
     	       b.setBounds(90,170,140, 40);
     	       
               //back button
               JButton back=new JButton("Back");    
               back.setBounds(10,170,75, 30); 

     		  //enter label
     		  JLabel label= new JLabel();
     		  label.setText("Enter ID");
     		  //setting bounds
     		  label.setBounds(10, 10, 100, 100);
     		  JTextField textfield= new JTextField();
     	      textfield.setBounds(110, 50, 130, 30);
     	      f.add(label);
     	      f.add(textfield);
     	      f.add(b); 
     	      f.add(back);
     	      f.setSize(300,300);    
     	      
     	      f.setLayout(null);    
     	      f.setVisible(true);    
     	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	      
     	   //action listener and links the message to the Submit button to be displayed after Submit is clicked
              b.addActionListener(new ActionListener() {           
                  
                  @Override
                  public void actionPerformed(ActionEvent arg0) {
                	     String id=textfield.getText();
                	     boolean val=TeacherOperation.deleteStudent(id);
                         if(val) 
                	     label.setText("ID Deleted");   
                         else
                         label.setText("ID cannot be deleted.");
                         label.setBounds(90, 90, 200, 100);
                         textfield.setText("");
                  }          
                });
              
              back.addActionListener(new ActionListener() {
                  
                  @Override
                  public void actionPerformed(ActionEvent arg0) {
                	  f.setVisible(false);
              }          
                });
     		  
     	  }
           
           public static void Display1() throws SQLException {  
        	   
               // Create and set up the window.  
               final JFrame frame = new JFrame("Enteries Display");  
               
               //back button
               JButton back=new JButton("Back");    
               back.setBounds(10,200,75, 30); 
         
               // Display the window.  
               frame.setSize(550, 350);  
               frame.setVisible(true);  
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                    
               // set flow layout for the frame
               frame.getContentPane().setLayout(new FlowLayout());  
               frame.add(back);
               
               Vector<String> columns=new Vector<>();
               columns.add("StudentID");
               columns.add("Subject 1");
               columns.add("Subject 2");
               columns.add("Subject 3");
               columns.add("Average");
               DefaultTableModel model = new DefaultTableModel();
               model.setColumnIdentifiers(columns);
               JTable table = new JTable();
               table.setModel(model);
               table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
               table.setFillsViewportHeight(true);
               JScrollPane scroll = new JScrollPane(table);
               scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);         
               frame.add(scroll);
               ResultSet rs=TeacherOperation.studentDetails();
               while(rs.next())
               {
            	   String Id=rs.getString("StudentID");
            	   int s1=rs.getInt("Subject1");
            	   int s2=rs.getInt("Subject2");
            	   int s3=rs.getInt("Subject3");
            	   double avg=rs.getDouble("Average");
            	   model.addRow(new Object[]{Id,s1,s2,s3,avg});
               }
               back.addActionListener(new ActionListener() {
                   
                   @Override
                   public void actionPerformed(ActionEvent arg0) {
                 	  frame.setVisible(false);
               }          
                 });
               
               }  
            

	public static void main(String[] args) {
			new MastermainGUI(); 
	}
		
}