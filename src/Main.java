public class Main {


	public static void main(String[] args) {

		System.out.println("Verbindung wird hergestellt...");
		Parser p = new Parser(args);
		Connector con = new Connector(p.getHost(), p.getPort(), p.getDatabase(), p.getUser(), p.getPass());
		con.connect();
	}

}
