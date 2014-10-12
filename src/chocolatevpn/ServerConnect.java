package chocolatevpn;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnect {

	Socket server;
	String serverIP;
	String clientIP;
	InputStream inputFromClient;
	String sharedSecret;
	
	public void initServerConnection(String port, String sharedSecret){		
		try {
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
			System.out.println("Waiting for connection from client.");
			server = serverSocket.accept();
			
			System.out.println("connected");
			inputFromClient = server.getInputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		serverIP = server.getLocalAddress().getHostAddress();
		clientIP = server.getInetAddress().getHostAddress();
		System.out.println(clientIP);
		this.sharedSecret = sharedSecret;
	}
	
	public Boolean mutualAuthentication(){
		int b;
		
		
		return false;
		
	}
	
	
	
	
}
