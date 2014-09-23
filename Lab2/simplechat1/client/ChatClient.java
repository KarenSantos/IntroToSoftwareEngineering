// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.*;

import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host
	 *            The server to connect to.
	 * @param port
	 *            The port number to connect on.
	 * @param clientUI
	 *            The interface type variable.
	 */

	public ChatClient(String host, int port, ChatIF clientUI)
			throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		openConnection();
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg
	 *            The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		clientUI.display(msg.toString());
	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message
	 *            The message from the UI.
	 */
	public void handleMessageFromClientUI(String message) {
		
		// **** Changed for E50' - JI and KS
		if (message.startsWith("#")) {
			
			String[] messages = message.split(" ");
			
			String message1 = messages[0];
			
			switch (message1.toLowerCase()) {
            case "#quit": 
            	quit();
                break;
                
            case "#logoff":
            	try {
        			closeConnection();
        		} catch (IOException e) {
        			System.out.println("exeption called!!");
        		}
            	break;
            case "#sethost":
            	
            	if (!isConnected()){
            		String message2 = messages[1];
            		setHost(message2);
            	} else {
            		clientUI.display("Error: please logoff to set host.");
            	}
            	break;
            	
            case "#setport":
            	if (!isConnected()){
            		String message2 = messages[1];
            		setPort(Integer.parseInt(message2));
            	} else {
            		clientUI.display("Error: please logoff to set port.");
            	}
            	break;
            	
            case "#login":
            	if (!isConnected()){
            		try {
						openConnection();
					} catch (IOException e) {
						System.out.println("exeption called!!");
					}
            	} else {
            		clientUI.display("Error: please logoff to login.");
            	}
            	break;
            	
            case "#gethost":
            	clientUI.display(getHost());
            	break;
            	
            case "#getport":
            	clientUI.display("" + getPort());
            	break;
            
            default: 
                // TODO ask if is trying to use a command
            	clientUI.display("This command is invalid, try another command.");
                break;
        }
			
		} else {
			try {
				sendToServer(message);
			} catch (IOException e) {
				clientUI.display("Could not send message to server.  Terminating client.");
				quit();
			}
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

	/**
	 * This method displays a method if the server has shutdown and terminates
	 * the client.
	 */
	@Override
	protected void connectionException(Exception exception) {
		// **** Changed for E49' - JI and KS
		clientUI.display("Server has shutdown. Terminating client.");
		quit();
	}
}
// End of ChatClient class
