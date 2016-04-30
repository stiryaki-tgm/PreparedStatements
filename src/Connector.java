import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connector {

	private PGSimpleDataSource ds;
	private Connection con;


	public Connector(String host, int port, String database, String user, String password) {
		ds = new PGSimpleDataSource();

        ds.setServerName(host);
        ds.setPortNumber(port);

        ds.setDatabaseName(database);
        ds.setUser(user);
        ds.setPassword(password);
	}

	public void connect() {
        try {

            con = ds.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
	}

	public void closeConnection() {
        try {

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);

        }
	}

	public PreparedStatement prepareStmnt(String stm) {
        try {
            return con.prepareStatement(stm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

}
