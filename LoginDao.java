import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	private String url="jdbc:postgresql://localhost:5432/FormApp";
	private String r="postgres";private String pass="Dh@ny@07";
	private String driver="org.postgresql.Driver";
	public void LoadDriver(String driver)
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
	}
	public Connection connect()
	{
		Connection  con=null;
		try {
			 con=DriverManager.getConnection(url,r,pass);
			if(con!=null)
				System.out.println("Successfully con");
			else
				System.out.println("NOO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	boolean Check(String username,String password)
	{
		int c=0;
		LoadDriver(driver);
		Connection con=connect();
		String sql="select * from UserDet";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				if((username.equals(rs.getString(1)))&&(password.equals(rs.getString(2))))
				{
					c++;
				}
			}
			if(c==0)
			{
				System.out.println("true");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;

	}
	void Insert(String username,String password)
	{
		
		try {
			LoadDriver(driver);
			Connection con=connect();
			String sql="Insert into UserDet(username,password) values('"+username+"','"+password+"')";
			Statement st=con.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
