
import java.sql.Statement;

import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class T6 {

	public static void main(String[] args) throws Exception {

		try (Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from employee")) 
		{
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++)
				System.out.print(rsmd.getColumnName(i) + "       ");
			System.out.println();
			while (rs.next()) {
				for (int i = 1; i <= count; i++)
					System.out.print(rs.getString(i) + "         ");
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
