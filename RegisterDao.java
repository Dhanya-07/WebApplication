import java.sql.*;
public class RegisterDao {
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
		System.out.println("cONN CLASS ");
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
	public String Insert(Member m,String req)
	{
	  LoadDriver(driver);
		System.out.println("insert");
		Connection con=connect();
		String res="Successfully Submitted";
		if(req!=null) {
		if(req.equalsIgnoreCase("Submit"))
			res="Successfully Submitted";
		else if(req.equalsIgnoreCase("Cancel"))
			res="Form is not submitted cancelled";
		}
		try {
		//String sql="INSERT INTO public.Member VALUES(m.getName_p(),m.getAge_p(),m.getGender_p(),'m.getFav_dir()+','+m.getFav_mov()+')";
		String sql="INSERT INTO Member VALUES('"+m.getName_p()+"','"+m.getAge_p()+"','"+m.getGender_p()+"','"+m.getFav_dir()+"','"+m.getFav_mov()+"')";
		
			Statement pst=con.createStatement();
			pst.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			res="Enter the data!";
		}
		return res;
	}
	public void Statistics(String fav_dir,String fav_mov)
	{ 
			try 
			{
				LoadDriver(driver);
				Connection con=connect();
				String sql="";
				Statement st=con.createStatement();
				if(fav_dir.equals("Sudha Kongara Prasad"))
				{
					sql="update Votes set dircount=dircount+1 where director like 'Sudha Kongara Prasad'";
				}
				else if(fav_dir.equals("Mari Selvaraj"))
				{
					sql="update Votes set dircount=dircount+1 where director like 'Mari Selvaraj'";
				}
				else if(fav_dir.equals("Prasanth Varma"))
				{
					sql="update Votes set dircount=dircount+1 where director like 'Prasanth Varma'";
				}
				else if(fav_dir.equals("Manu Ashokan"))
				{
					sql="update Votes set dircount=dircount+1 where director like 'Manu Ashokan'";
				}
				else if(fav_dir.equals("Raghu Samarth"))
				{
					sql="update Votes set dircount=dircount+1 where director like 'Raghu Samarth'";
				}
				else
				{
					sql="update Votes set dircount=dircount+1 where director like ' Meghna Gulzar'";
					
				}
				st.executeUpdate(sql);
				
				//Movie
				if(fav_mov.equals("Soorarai Potru"))
				{
					sql="update Votes set moviecount=moviecount+1 where movie like 'Soorarai Potru'";
				}
				else if(fav_mov.equals("Uyare"))
				{
					sql="update Votes set moviecount=moviecount+1 where movie like 'Uyare'";
				}
				else if(fav_mov.equals("Pariyerum Perumal"))
				{
					sql="update Votes set moviecount=moviecount+1 where movie like 'Pariyerum Perumal'";
				}
				else if(fav_mov.equals("Awe"))
				{
					sql="update Votes set moviecount=moviecount+1 where movie like 'Awe'";
				}
				else if(fav_mov.equals("Raazi"))
				{
					sql="update Votes set moviecount=moviecount+1 where movie like 'Raazi'";
				}
				else
					sql="update Votes set moviecount=moviecount+1 where movie like 'Law'";
					
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public int[] Rank_Dir()
	{
		int arr[]=new int[6];int k=0;
		String sql="";int c=1;
		try {
			LoadDriver(driver);
			System.out.println("stat");
			Connection con=connect();
			
			int v;
			Statement st=con.createStatement();
			sql="select count(*) from Votes";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				c=rs.getInt(1);
			}
			sql="select dircount from Votes order by director asc";
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				v=rs.getInt(1);
				arr[k++]=(int)(( (double)(v*100/c)));
				System.out.println(arr[k-1]);
			}
			return arr;
			
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return arr;
	}
	//Movie
	public int[] Rank_Mov()
	{
		int arr[]=new int[6];int k=0;
		String sql="";int c=1;
		try {
			LoadDriver(driver);
			Connection con=connect();
			
			int v;
			Statement st=con.createStatement();
			sql="select count(*) from Votes";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				c=rs.getInt(1);
				System.out.println("c: "+c);
			}
			sql="select moviecount from Votes order by director asc";
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				v=rs.getInt(1);
				System.out.println("v: "+v);
				arr[k++]=(int)(( (double)(v*100/c)));
				System.out.println(arr[k-1]);
			}
			return arr;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return arr;
	}

}
