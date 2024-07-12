package chap1;
import java.sql.*;

public class DataRetrive {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nec","nec");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from customer ");
			
			while(rs.next()) {
				
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				String loc = rs.getString("loc");
				String email = rs.getString("email");
				
				System.out.println("Customer ID : " +cid);
				System.out.println("Customer Name : " + cname);
				System.out.println("Location : " + loc);
				System.out.println("Email ID : " + email);
				
				System.out.println("************");
			}
			
		} catch (Exception obj) {
			
			obj.printStackTrace();
		}
	}
}