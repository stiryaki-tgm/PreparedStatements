import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Connector {

	private PGSimpleDataSource ds;

	private Connection con;

	private Main main;

	public Connector(String host, int port, String database, String user, String password) {

	}

	public void connect() {

	}

	public void closeConnection() {

	}

	public PreparedStatement prepareStmnt(String stm) {
		return null;
	}

}
