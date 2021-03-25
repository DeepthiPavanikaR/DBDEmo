
import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ScrollableReultSetDemo {

	public static void main(String[] args) throws Exception {

		try (Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from department",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = pst.executeQuery())
		{
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			
			System.out.println();
			
			while(rs.previous())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
