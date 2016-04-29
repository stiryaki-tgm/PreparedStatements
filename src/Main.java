public class Main {


	public static void main(String[] args) {

		System.out.println("Verbindung wird hergestellt...");
		Parser p = new Parser(args);
		Connector con = new Connector(p.getHost(), p.getPort(), p.getDB(), p.getUser(), p.getPassword());
		con.connect();
	}

}
