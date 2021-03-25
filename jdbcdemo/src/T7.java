
import java.sql.Statement;

import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;

public class T7 {

	public static void main(String[] args) throws Exception {
		int deptno = 20;
		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from employee where deptno =" + deptno))
		// #2 ResultSet rs = st.executeQuery("select * from employee where deptno =30"))
		// #1 ResultSet rs = st.executeQuery("select * from employee"))
		{
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getInt(4));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
