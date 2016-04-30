public class Main {


	public static void main(String[] args) {

		System.out.println("Verbindung wird hergestellt...");
		Parser p = new Parser(args);
		Connector con = new Connector(p.getHost(), p.getPort(), p.getDB(), p.getUser(), p.getPassword());
		con.connect();

		CRUD crud = new CRUD(con);

		System.out.println("Verbindung erfolgreich!\nDatensätze werden eingetragen...");

		for(int i=0;i<10000;i++)
		{
			//nummer,bezeichnung,gewicht
			crud.insertProdukt(i,"ProduktNr." + i,1);
		}
		System.out.println("Datensätze wurden eingetragen!");
	}

}
