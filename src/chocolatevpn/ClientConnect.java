package chocolatevpn;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientConnect {
	Socket clientSocket;
	String serverIP = null;
	String clientIP = null;
	InputStream serverStream;

	public void initClientConnection(int port, String host){
		serverIP = host;
		clientIP = clientSocket.getLocalAddress().getHostAddress();
		try{
			System.out.println("Connecting to Server...");
			clientSocket = new Socket(host, port);
			serverStream = clientSocket.getInputStream();
			System.out.println("Created Client Socket\n");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
			
			
			

		
}
