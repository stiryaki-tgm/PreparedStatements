import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD {

	private PreparedStatement crud;

	private Connector con;

	/**
	 * Konstruktor f�r die CRUD Operationen
	 * @param con wird gebraucht f�r die Verbindung zur Datenbank
	 */
	public CRUD(Connector con) {
		this.con = con;
	}
	
	/** 
	 * CREATE - Eine Methode, dass ein Produkt in die mysql datenbank(schokofabrik) in die Tabelle Produkt einf�gt.
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
	 * READ - Es f�hrt den Prepared Statement mit einem bestimmten int wert f�r 
	 * die SELECT Abrage.
	 * @param border definiert welcher wert selektiert werden soll
	 * @return the ResultSet die auszugebenden Daten
	 * @throws SQLException f�r die Exception aus wenn ein Fehler auftritt
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

	public void updateProdukt(String bez, int gewicht) {

	}

	public void deleteProdukt(int key) {

	}

}
