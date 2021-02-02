package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DatabaseOpertion {

	 private static Connection conn = null;
	 private static ResultSet rs=null;
	 private static String table_name="C11";
	 
	 //Constructor which on call establish connection
	 DatabaseOpertion(){createConnection();}
	
	 //function to establish connection to DBMS
	public static void createConnection()
	{
		 try { Class.forName("com.mysql.cj.jdbc.Driver"); }
		 catch (Exception ex) { System.out.println("Driver Not Found"); }
	  	       
	        try {
	        	String user="root";
	        	String password="root";
	        	String url="jdbc:mysql://localhost/classes?";
	            conn=DriverManager.getConnection(url,user,password);
	            System.out.println("Connection installed Successfully");
	        } 
	        catch (SQLException ex) {
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        }
	}
	
	//function to create new Table for a particular class
	protected static void tableCreate(String name) {
		try {
	String Query="CREATE TABLE "+name+" (StudentID varchar(10),Subject1 INT,Subject2 INT,Subject3 INT,Average FLOAT,PRIMARY KEY (StudentID));";
	PreparedStatement stmt=conn.prepareStatement(Query);
	stmt.executeUpdate();
	table_name=name;
	System.out.println("Value added");
	stmt.close();
	}
		catch(Exception e) {System.out.println("Table Already Exisiting");}
	}

	//function to close the connection to the DBMS
	static void closeConnection() {
		try{conn.close();}
		catch(Exception e) {e.printStackTrace();}
		}
	
	//function to show all the tables in the DBMS
	public static void showTables() {
	try {
		Statement stmt=conn.createStatement();
		rs=stmt.executeQuery("SHOW TABLES;");
		while(rs.next())
		{
		   System.out.println(rs.getString(1));	
		}
     	}
	catch(Exception e) {e.printStackTrace();}
	}
	
	//function to add the details in the Table
	protected static void enterDetails(String Id,int s1,int s2,int s3) {
		double avg=(s1+s2+s3)/3;
		try {
		String Query="INSERT INTO "+table_name+" (StudentID, Subject1, Subject2, Subject3, Average) VALUES (?,?,?,?,?);";
		PreparedStatement stmt=conn.prepareStatement(Query);
		stmt.setString(1, Id);
		stmt.setInt(2,s1);
		stmt.setInt(3,s2);
		stmt.setInt(4,s3);
		stmt.setDouble(5,avg);
		System.out.println(stmt);
		stmt.executeUpdate();
		stmt.close();
		}
		catch(Exception e) {System.out.println("Values could not be entered");}
	}
	
	//function to set current working table
	public static void currentTable(String name) {
		table_name=name;
	}
	
	//function to update a particular entry in table
	protected static void updateDetails(String Id,int s1,int s2,int s3) {
		double avg=(s1+s2+s3)/3;
		try {
			String Query="UPDATE "+table_name+" SET Subject1 = ? , Subject2 = ?, Subject3 = ? , Average = ?  WHERE StudentID = ?;";
			PreparedStatement stmt=conn.prepareStatement(Query);
			
			 stmt.setInt(1, s1); 
			 stmt.setInt(2,s2);
			 stmt.setInt(3,s3);
			 stmt.setDouble(4,avg);
			 stmt.setString(5,Id);
			 System.out.println(stmt);
			 stmt.executeUpdate();
			 stmt.close();
			 System.out.println("Values Upadated Sucessfully.");
		}
		catch(Exception e) {System.out.println("Value could not be Updated.");  e.printStackTrace();}
	}
	
	//function to show all the entries in the tale
	public static ResultSet showDetails() {
		try {
		  String Query="SELECT * FROM "+table_name;
		  PreparedStatement stmt=conn.prepareStatement(Query);
		  System.out.println(stmt);
		  rs=stmt.executeQuery();
			/*
			 * while(rs.next()) { System.out.print("StudentID: "+rs.getString(1));
			 * System.out.print("\tSubject1: "+rs.getInt(2));
			 * System.out.print("\tSubject2: "+rs.getInt(3));
			 * System.out.print("\tSubject3: "+rs.getInt(4));
			 * System.out.print("\tAverage: "+rs.getDouble(5)); System.out.println(); }
			 */
		  return rs;
		}
		catch(SQLException e) {System.out.println("Values couldn't be fetched."); e.printStackTrace();}
		return rs;
	}
	
	//function to find specific data from the Table
	public static ArrayList<String> specificData(String id)
	{
		ArrayList<String> ar=new ArrayList<>();
		try {
			String Query="SELECT * FROM "+table_name+" WHERE StudentID = '"+id+"';";
			PreparedStatement stmt=conn.prepareStatement(Query);
			System.out.println(stmt);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				ar.add(rs.getString("StudentID"));
				ar.add(rs.getString("Subject1"));
				ar.add(rs.getString("Subject2"));
				ar.add(rs.getString("Subject3"));
			}
			}
		catch(Exception e) {	}
	 return ar;  	
	}
	
	//function to delete a particular entry in the table
	protected static void deleteDetails(String Id){
		try {
			String Query="DELETE FROM "+table_name+" WHERE StudentID =?";
			PreparedStatement stmt=conn.prepareStatement(Query);
			stmt.setString(1,Id);
			stmt.executeUpdate();
			System.out.println("Value successfully deleted.");
		}
		catch(Exception e) { System.out.println("Deletion not successfull.");  e.printStackTrace();}
	}
	
	//--------------------------------------------BETA FEATURE--------------------------------------------
	
	//function to print all the data in the table into a file
	protected static void printDetails(String filename){
		try {
			String Query="SELECT * FROM "+table_name;
		    PreparedStatement stmt=conn.prepareStatement(Query);
			rs=stmt.executeQuery();
		}
		catch(Exception e) {}
	}
	
	//function to delete a table
	protected static void deleteTable(String tableName){
		try {
			String Query="DROP TABLE "+tableName;
			PreparedStatement stmt=conn.prepareStatement(Query);
			stmt.executeUpdate();
			System.out.println("Table Sucessfully Deleted.");
		}
		catch(Exception e) { System.out.println("Table not found. Check the Name."); e.printStackTrace();}
	}
	public static void main(String[] args) {}
}
