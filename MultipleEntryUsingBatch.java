package chap1;
import java.sql.*;
import java.util.Scanner;

public class MultipleEntryUsingBatch {
	public static void main(String []args) {
		try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","nec","nec");
		Scanner sc=new Scanner(System.in);
		String user_value="";
		
		PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?)");
		
		do {
			System.out.println("Enter id: ");
			String cid=sc.nextLine();
			System.out.println("Enter cname: ");
			String cname=sc.nextLine();
			System.out.println("Enter location: ");
			String loc=sc.nextLine();
			System.out.println("Enter email: ");
			String email=sc.nextLine();
			ps.setString(1, cid);
			ps.setString(2, cname);
			ps.setString(3, loc);
			ps.setString(4, email);
			ps.addBatch();
			System.out.println("enter choice (yes/no):");
			user_value=sc.nextLine();
		}while(user_value.equals("yes"));
		ps.executeBatch();
		System.out.println("SUCCESS");
		
		}catch(Exception obj) {
			obj.printStackTrace();
		}
		}

}
