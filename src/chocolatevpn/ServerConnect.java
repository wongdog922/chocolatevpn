package chocolatevpn;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnect {

	Socket server;
	String serverIP;
	InputStream inputFromClient;
	
	public void initServerConnection(String port, String sharedSecret){
		serverIP = server.getLocalAddress().getHostAddress();
		
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
			System.out.println("Waiting for connection from client.");
			server = serverSocket.accept();
			
			inputFromClient = server.getInputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
