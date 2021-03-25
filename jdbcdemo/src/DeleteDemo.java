
import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDemo {

	public static void main(String[] args) throws Exception {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pst = con.prepareStatement("delete from employee"))
		{
			int count = pst.executeUpdate();
			System.out.println(count + " Rows Deleted");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
