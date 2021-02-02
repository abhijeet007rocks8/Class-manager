package Backend;

import java.sql.SQLException;
import java.util.ArrayList;
public class StudentBackend {
	
	public StudentBackend() {DatabaseOpertion.createConnection(); DatabaseOpertion.tableCreate("C11");}
    public static ArrayList<String> details(String id) throws SQLException
    {
    	new StudentBackend();
    	ArrayList<String> ar=new ArrayList<>();
    	ar=DatabaseOpertion.specificData(id);
    	return ar;
    }
}
