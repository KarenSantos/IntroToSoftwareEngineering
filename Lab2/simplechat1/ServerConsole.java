import java.io.BufferedReader;
import java.io.InputStreamReader;

import common.ChatIF;

//Ass3
//6312215 - Jolayemi Ilori
//7997484 - Karen Santos
//**** Changed for E50' - JI and KS

/**
 * This class constructs the UI for a EchoServer. It implements the chat
 * interface in order to activate the display() method.
 *
 * @author Jolayemi Ilori
 * @author Karen Santos
 * @version September 2014
 */
public class ServerConsole implements ChatIF {

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;
	
	// Instance variables **********************************************
	
	/**
	 * The instance of the client that created this ConsoleChat.
	 */
	EchoServer server;
	
	// Constructors ****************************************************
	
	/**
	 * Constructs an instance of the ServerConsole UI.
	 *
	 * @param port
	 *            The port to connect to.
	 */
	public ServerConsole(int port){
		server = new EchoServer(port, this);
		
		try {
			server.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
	
	// Instance methods ************************************************

		/**
		 * This method waits for input from the console. Once it is received, it
		 * sends it to the server's message handler.
		 */
		public void accept() {
			try {
				BufferedReader fromConsole = new BufferedReader(
						new InputStreamReader(System.in));
				String message;

				while (true) {
					message = fromConsole.readLine();
					server.handleMessageFromServerUI(message);
				}
			} catch (Exception ex) {
				System.out.println("Unexpected error while reading from console in the server!");
			}
		}
	
	@Override
	public void display(String message) {
		System.out.println("> " + message);
	}
	
	// Class methods ***************************************************

		/**
		 * This method is responsible for the creation of the server instance (there
		 * is no UI in this phase).
		 *
		 * @param args
		 *            [0] The port number to listen on. Defaults to 5555 if no
		 *            argument is entered.
		 */
		public static void main(String[] args) {
			int port = 0; // Port to listen on

			try {
				port = Integer.parseInt(args[0]); // Get port from command line
			} catch (Throwable t) {
				port = DEFAULT_PORT; // Set port to 5555
			}

			ServerConsole sc = new ServerConsole(port);
			sc.accept(); // Wait for console data
			
		}

}
