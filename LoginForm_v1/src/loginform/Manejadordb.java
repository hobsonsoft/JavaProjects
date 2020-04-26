package loginform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class Manejadordb {
	public Connection conector(String servidor, int port, String database, String usuario, String password) throws SQLException, ClassNotFoundException  {
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Class.forName("org.postgresql.Driver");
		String uriconector="jdbc:postgresql://"+servidor+":"+port+"/"+database;
				 //"user="+usuario+";password="+password+";";
		Connection conectorsql;

			conectorsql = DriverManager.getConnection(uriconector,usuario, password);
		
		
	return conectorsql;	
	}

}
