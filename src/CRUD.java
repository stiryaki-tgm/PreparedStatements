import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CRUD für CREATE, READ, UPDATE UND DELETE
 * @author Oezsoy Ahmet 
 * @version 01.04.2016
 */
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
	
	/** 
	 * CREATE - Eine Methode, dass ein Produkt in die mysql datenbank(schokofabrik) in die Tabelle Produkt einfügt.
	 * @param num die nummer des Produktes
	 * @param bez die bezeichnung des Produktes
	 * @param gewicht das gewicht des Produktes
	 */
	public void insertProdukt(int num, String bez, int gewicht) {
		//Erstellen eines Prepared Statements
		crud = new con.prepareStmnt("INSERT INTO Produkt VALUES(?,?,?)");
		try{
			crud.setInt(1, num);
			crud.setString(2,bez);
			crud.setInt(3, gewicht);
			crud.execute();
		} catch(SQLException e) {
			System.out.println("Fehler aufgetreten!");
			System.out.println(e.getMessage());
			
		}
	}

	/**
	 * READ - Es führt den Prepared Statement mit einem bestimmten int wert für 
	 * die SELECT Abrage.
	 * @param border definiert welcher wert selektiert werden soll
	 * @return the ResultSet die auszugebenden Daten
	 * @throws SQLException für die Exception aus wenn ein Fehler auftritt
	 */
	public ResultSet readProdukt(int border) throws SQLException {
		crud = con.prepareStmnt("SELECT * FROM Produkt WHERE nummer > ?");
		crud.setInt(1, border);
		return crud.executeQuery();
	}

	/**
	 * READ - Gibt die Werte vom Resultset aus.
	 * @param rs der Resultset
	 */
	public void printProdukt(ResultSet rs) {
		try {
			while (rs.next()) {
				int num = rs.getInt(1);
				String bez = rs.getString(2);
				int gewicht = rs.getInt(3);
				System.out.println(num + " " + bez + " " + gewicht);
			}
		} catch (SQLException e) {
			System.err.println("Ausgabe fehlgeschlagen!");
		}
	}

	/**
	 * UPDATE - Ersetzt den Platzhalter mit den Parametern und führt das Prepared Statement aus.
	 * @param bez Bezeichnung für das Produkt
	 * @param gewicht für das Produkt
	 */
	public void updateProdukt(String bez, int gewicht) {
		crud = con.prepareStmnt("UPDATE Produkt SET bez = ? WHERE gewicht = ?");
		try {
			crud.setString(1, bez);
			crud.setInt(2, gewicht);
			crud.execute();
		} catch (SQLException e) {
			System.err.println("Das Updaten vom Produkt wurde fehlgeschlagen!");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * DELETE - Ersetzt den Platzhalter mit den Parametern und führt das Prepared Statement aus.
	 * @param key Bezeichnung für das Produkt
	 */
	public void deleteProdukt(int key) {
		crud = con.prepareStmnt("DELETE FROM Produkt WHERE bez = ?");
		try {
			crud.setString(1, key);
			delete.execute();
		} catch (SQLException e) {
			System.err.println("Löschen eines Produktes fehlgeschlagen!");
			System.err.println(e.getMessage());
		}
	}

}
