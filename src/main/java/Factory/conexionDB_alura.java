package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class conexionDB_alura {
private DataSource datasource;
	
	
	public conexionDB_alura(){
		var poolDataSouce = new ComboPooledDataSource();
		
		poolDataSouce.setJdbcUrl("jdbc:mysql://localhost/Hotel_Alura_Challenge_ONE?useTimeZone=true&serverTimeZone=UTC");
		poolDataSouce.setUser("root");
		poolDataSouce.setPassword("3012452439");
		poolDataSouce.setMaxPoolSize(10);
		
		
		this.datasource = poolDataSouce;
	}
public Connection ConectarConexion(){
	try {
		return this.datasource.getConnection();
	} catch (SQLException e) {
		System.out.println("hubo un error");
		throw new RuntimeException(e);

	}
	}
}
