
import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class T10 {

	public static void main(String[] args) throws Exception {
		
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)"))
				
		{
			pst.setInt(1, 115);
			pst.setString(2, "Samson");
			pst.setDouble(3, 800);
			pst.setInt(4, 10);
			int count = pst.executeUpdate();
				System.out.println(count+" Rows Inserted");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
