
import java.sql.Statement;

import com.cg.jdbcdemo.dao.conn.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;

public class T5 {

	public static void main(String[] args) throws Exception {

		try (Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee"))
			{
				while (rs.next())
				//System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
					System.out.println(rs.getString("emp_no") + " " + rs.getString("emp_name") + " " + rs.getString("emp_sal") + " " + rs.getString("deptno"));
		} catch (Exception e) {
			System.out.println(e);
		} 
		/*finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					rs.close();
				if (con != null)
					rs.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}*/
	}

}
