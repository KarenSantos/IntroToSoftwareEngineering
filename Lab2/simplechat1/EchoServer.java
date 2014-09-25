// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.IOException;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import common.ChatIF;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the server.
	 */
	ChatIF serverUI;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port
	 *            The port number to connect on.
	 * @param serverUI
	 *            The interface type variable.
	 */
	public EchoServer(int port, ChatIF serverUI) {
		super(port);
		this.serverUI = serverUI;
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg
	 *            The message received from the client.
	 * @param client
	 *            The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {

		// **** Changed for E51' - JI and KS
		if (((String) msg).startsWith("#login")) {
			if (client.getInfo("LoginID").equals(null)) {
				client.setInfo("LoginID", ((String) msg).split(" ")[1]);
			} else {
				try {
					client.sendToClient("Error: You cannot set another login.");
				} catch (IOException e) {
				}
			}
		} else {
			String clientID = (String) client.getInfo("LoginID");
			System.out.println("Message received from " + clientID + ": " + msg
					+ " from " + client);
			this.sendToAllClients(clientID + ": " + msg);
		}
	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message
	 *            The message from the UI.
	 */
	public void handleMessageFromServerUI(String message) {

		// **** Changed for E50' - JI and KS
		if (message.startsWith("#")) {

			String[] messages = message.split(" ");

			String message1 = messages[0];

			switch (message1.toLowerCase()) {
			case "#quit":
				try {
					close();
				} catch (IOException e) {
					serverUI.display("Could not close. Try again later.");
				}
				break;

			case "#stop":
				stopListening();
				break;

			case "#close":
				stopListening();
				for (Thread client : getClientConnections()) {
					try {
						((ConnectionToClient) client).close();
					} catch (IOException e) {
					}
				}
				break;

			case "#setport":
				if (!isListening() && getNumberOfClients() == 0) {
					String message2 = messages[1];
					setPort(Integer.parseInt(message2));
				} else {
					serverUI.display("Error: please close the server to set port.");
				}
				break;

			case "#start":
				if (!isListening()) {
					try {
						listen();
					} catch (IOException e) {
					}
				} else {
					serverUI.display("Error: please stop the server to start.");
				}
				break;

			case "#getport":
				serverUI.display("" + getPort());
				break;

			default:
				// TODO ask if is trying to use a command
				serverUI.display("This command is invalid, try another command.");
				break;
			}

		} else {
			String serverMsg = "SERVER MSG> " + message;
			sendToAllClients(serverMsg);
			serverUI.display(serverMsg);
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port "
				+ getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * stops listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	/**
	 * This method is called each time a new client connection is accepted.
	 * 
	 * @param client
	 *            the connection connected to the client.
	 */
	@Override
	protected void clientConnected(ConnectionToClient client) {
		// **** Changed for E49' - JI and KS
		System.out.println("A client has connected.");

	}

	/**
	 * This method is called each time a client is disconnection from the
	 * server.
	 *
	 * @param client
	 *            the connection with the client.
	 */
	@Override
	synchronized protected void clientDisconnected(ConnectionToClient client) {
		// **** Changed for E49' - JI and KS
		System.out.println("A client has disconnected.");
	}

}
// End of EchoServer class
