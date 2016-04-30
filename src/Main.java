public class Main {


	public static void main(String[] args) {

		Parser p = new Parser(args);
		Connector con = new Connector(p.getHost(), p.getPort(), p.getDB(), p.getUser(), p.getPassword());
		System.out.println("Verbindung wird hergestellt...");
		con.connect();
		System.out.println("Verbindung erfolgreich!\nDatensätze werden eingetragen...");
		CRUD crud = new CRUD(con);

		for(int i=0;i<10000;i++)
		{
			//nummer,bezeichnung,gewicht
			crud.insertProdukt(i,"ProduktNr." + i,1);
		}
		System.out.println("Datensätze wurden eingetragen!");
	}

}
