package com.blog.util;
import java.sql.*;

public class Database {
	public static Connection getConnaction()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
      	  	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","ravi","destiny555");
      	  	return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static void close(Connection con)
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}