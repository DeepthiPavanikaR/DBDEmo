
import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDemo {

	public static void main(String[] args) throws Exception {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pst = con.prepareStatement("update employee set emp_sal=? where emp_no =?"))

		{
			pst.setDouble(1, 300);
			pst.setInt(2, 114);
			int count = pst.executeUpdate();
			System.out.println(count + " Rows Updated");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
