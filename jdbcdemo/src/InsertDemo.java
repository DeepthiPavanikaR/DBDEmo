
import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDemo {

	public static void main(String[] args) throws Exception {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)"))

		{//if rows are deleted or if no rows exits then v can insert rows in this way
			pst.setInt(1, 115);
			pst.setString(2, "Samson");
			pst.setDouble(3, 800);
			pst.setInt(4, 10);
			int count = pst.executeUpdate();
			System.out.println(count + " Rows Inserted");
			
			pst.setInt(1, 114);
			pst.setString(2, "John");
			pst.setDouble(3, 700);
			pst.setInt(4, 20);
			count = pst.executeUpdate();
			System.out.println(count + " Rows Inserted");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
