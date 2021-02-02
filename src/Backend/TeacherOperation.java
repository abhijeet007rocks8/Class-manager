package Backend;

import java.sql.ResultSet;
public class TeacherOperation{
 
	protected String Id;
	protected int sub1,sub2,sub3;
	
	public TeacherOperation(){	
          DatabaseOpertion.createConnection(); 
          DatabaseOpertion.tableCreate("C11");      
	}
	
	    public static boolean addStudent(String id,int s1,int s2, int s3){
		try {	DatabaseOpertion.enterDetails(id,s1,s2,s3); return true;}
		catch(Exception e)
		{ e.printStackTrace(); return (false);} }
	    
	    public static boolean updateStudent(String id,int s1, int s2, int s3) {
	    	try { DatabaseOpertion.updateDetails(id,s1,s2,s3);return true; }
	    	catch(Exception e) {e.printStackTrace();return false;}
	    }
	    
	    public static boolean deleteStudent(String id) {
	    	try { DatabaseOpertion.deleteDetails(id);return true;}
	    	catch(Exception e) {e.printStackTrace();return false;}
	    }
	    
	    public static ResultSet studentDetails() {
	    	ResultSet rs=DatabaseOpertion.showDetails();
	    	try {
				/*
				 * while(rs.next()) { System.out.print("StudentID: "+rs.getString(1));
				 * System.out.print("\tSubject1: "+rs.getInt(2));
				 * System.out.print("\tSubject2: "+rs.getInt(3));
				 * System.out.print("\tSubject3: "+rs.getInt(4));
				 * System.out.print("\tAverage: "+rs.getDouble(5)); System.out.println(); }
				 */
	    		return (rs);
	    	}
	    	catch(Exception e) {e.printStackTrace();}
			return (rs);
	    }
	    
	    //-------------------------------------------BETA FEATURES TO ADD--------------------------------------------------//
	    void addClass(String name) {
	    	try { DatabaseOpertion.tableCreate(name);}
	    	catch(Exception e) {e.printStackTrace();}
	    }
	    
	    void removeClass(String name) {
	    	try { DatabaseOpertion.deleteTable(name);}
	    	catch(Exception e) {e.printStackTrace();}
	    }
	    
}
