
import java.sql.Statement;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class T3 {

	public static void main(String[] args){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties props = new Properties();
			props.setProperty("user", "deepu");
			props.setProperty("password", "vaishu");

			con = DriverManager.getConnection(url, "deepu", "vaishu");
			st = con.createStatement();
			rs = st.executeQuery("select * from employee");
			while (rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
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

		}
	}

}
