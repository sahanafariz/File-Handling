package chap1;
import java.util.*;
import java.io.*;
import java.sql.*;

public class Data {
	public static void main(String []args) {
	try{
	File f=new File("C:\\Users\\Asus\\Pictures\\1-1-Dark-Moon-Sky-Tree-Wallpaper.jpg");
	FileInputStream fin=new FileInputStream(f);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","nec","nec");
	String query="insert into files values (?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1, "f-1");
	ps.setBinaryStream(2, fin,fin.available());
	int res=ps.executeUpdate();
	if(res>0)
	{
		System.out.println("Successfully inserted row...");
	}
	
	}catch(Exception obj) {
		obj.printStackTrace();
	}
	}
}
