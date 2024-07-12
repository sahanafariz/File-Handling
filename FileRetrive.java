package chap1;
import java.io.*;
import java.sql.*;
public class FileRetrive {
	public static void main(String []args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","nec","nec");
			//String query="insert into files values (?,?)";
			Statement st=con.createStatement();
			ResultSet re=st.executeQuery("select *from files");
			int pos=0;
			while(re.next()) {
				Blob b=re.getBlob("filedata");
				byte[] by=b.getBytes(++pos,(int)b.length());
				java.util.Random r=new java.util.Random();
				int random_num=r.nextInt(100000);
				File f=new File("C:\\Users\\Asus\\Pictures\\Files"+random_num+".jpg");
				FileOutputStream fout=new FileOutputStream(f);
				fout.write(by);
				fout.close();
			}
			
			System.out.println("Sucess.......");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


