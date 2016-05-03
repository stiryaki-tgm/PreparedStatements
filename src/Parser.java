import org.apache.commons.cli.*;

public class Parser {

	private Options opt;
    private CommandLine cli;
    private HelpFormatter helper;

	public Parser(String[] args) {
        helper = new HelpFormatter();
        setUpOptions();
        parse(args);
	}

    /**
     *  Erstellt die Optionen für Parametereingaben
     */
	public void setUpOptions() {
        opt = new Options();
        opt.addOption(Option.builder("H").argName("hostname").desc("Adresse des Servers").hasArg().longOpt("host")
                .numberOfArgs(1).build());
        opt.addOption(Option.builder("d").argName("database").desc("Datenbankname").hasArg()
                .longOpt("database").numberOfArgs(1).build());
        opt.addOption(Option.builder("P").argName("port").desc("Port des Servers").hasArg().longOpt("port")
                .numberOfArgs(1).build());
        opt.addOption(Option.builder("u").argName("username").desc("Name des Users").hasArg().longOpt("user")
                .numberOfArgs(1).build());
        opt.addOption(Option.builder("p").argName("password").desc("Password des Users").hasArg().longOpt("password")
                .numberOfArgs(1).build());
        opt.addOption(Option.builder("h").argName("help").desc("Hile").hasArg().longOpt("help")
                .numberOfArgs(0).build());

    }

    /**
     *   Parst die Parameter, mit den vordefinierten Optionen
     */
    private void parse(String[] args)
    {
        DefaultParser parser = new DefaultParser();
        try {
            cli = parser.parse(opt, args);
        } catch (ParseException exp) {
            exp.printStackTrace();
            System.exit(-1);
        }
        help();
    }

    /**
    * Gibt den Namen der Datanbank zurueck
    * @return Datenbank-Name
    */
	public String getDB() {
        if (cli.hasOption("d"))
            return cli.getOptionValue('d');
        else {
                System.out.println("Datenbankname fehlt!");
                printHelper();
                System.exit(-1);
                return "";
        }
	}

    /**
     * Gibt den Namen des Users zurueck
     * @return User-Name
     */
	public String getUser() {
        if (cli.hasOption("u")) {
            return cli.getOptionValue('u');
        }
        else {

            System.out.println("User fehlt!");
            printHelper();
            System.exit(-1);
            return "";
        }
	}

    /**
     * Gibt das Password des Users zurueck
     * @return password
     */
	public String getPassword() {
        if (cli.hasOption("p"))
            return cli.getOptionValue('p');
        else {

            System.out.println("Password fehlt!");
            printHelper();
            System.exit(-1);
            return "";
        }
	}

    /**
     * Gibt den Port der Datenbank zurueck
     * @return Datenbank-Port
     */
	public int getPort() {
        if (cli.hasOption("P"))
            return Integer.parseInt(cli.getOptionValue('P'));
        else {

            System.out.println("Port fehlt!");
            printHelper();
            System.exit(-1);
            return -1;
        }
	}

    /**
     * Gibt die Server-IP zurueck
     * @return Datenbank-IP
     */
	public String getHost() {
        if (cli.hasOption("H"))
            return cli.getOptionValue('H');
        else {

            System.out.println("Server-IP fehlt!");
            printHelper();
            System.exit(-1);
            return "";
        }
	}

    /**
     * Gibt die Verwendung des Programs, mit ihren Optionen aus.
     * http://www.programcreek.com/java-api-examples/index.php?api=org.apache.commons.cli.HelpFormatter
     */
    public void help() {
        if (cli.hasOption('h')) {
            printHelper();
            System.exit(0);
        }
	}
    public void printHelper()
    {
        helper.printHelp("<filename>.jar", opt, true);
    }
}
