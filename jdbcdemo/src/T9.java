
import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class T9 {

	public static void main(String[] args) throws Exception {
		
		try (Connection con = DBConnection.getConnection();
				//PreparedStatement pst = con.prepareStatement("select * from employee");
				PreparedStatement pst = con.prepareStatement("select * from employee where deptno=?"))
				
		{
			pst.setInt(1, 10);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getInt(4));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
// ? is replaceable parameter or a query string