
import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AutoCommitOff {// it is committed whether autocommit is on or off
	// if u want to rollback then use rollback()

	public static void main(String[] args) throws Exception {

		try (Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)"))

		{
			con.setAutoCommit(false);
			pst.setInt(1, 115);
			pst.setString(2, "Samson");
			pst.setDouble(3, 800);
			pst.setInt(4, 10);
			int count = pst.executeUpdate();
			System.out.println(count + " Rows Inserted");
			con.commit();
			
			pst.setInt(1, 114);
			pst.setString(2, "John");
			pst.setDouble(3, 700);
			pst.setInt(4, 20);
			count = pst.executeUpdate();
			System.out.println(count + " Rows Inserted");
			con.rollback();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
