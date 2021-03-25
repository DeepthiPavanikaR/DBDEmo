
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class T1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, "deepu", "vaishu");
			st = con.createStatement();
			rs = st.executeQuery("select * from employee");
			while (rs.next())
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)// recently executed statement should come first
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

}
