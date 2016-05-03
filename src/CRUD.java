import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD {

	private PreparedStatement crud;

	private Connector con;

	/**
	 * Konstruktor für die CRUD Operationen
	 * @param con wird gebraucht für die Verbindung zur Datenbank
	 */
	public CRUD(Connector con) {
		this.con = con;
	}
	
	public void insertProdukt(int num, String bez, int gewicht) {

	}

	public ResultSet readProdukt(int border) {
		return null;
	}

	public void printProdukt(ResultSet rs) {

	}

	public void updateProdukt(String bez, int gewicht) {

	}

	public void deleteProdukt(int key) {

	}

}
