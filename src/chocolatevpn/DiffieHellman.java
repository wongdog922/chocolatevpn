package chocolatevpn;

import java.util.Random;

public class DiffieHellman {
	
	int g = 2;
	int p = 25; //9949
	
	//a or b integer in the alice and bob example
	public int generateSecretInteger(){
		Random random = new Random();
		
		return random.nextInt(56);
	}
	
	//A or B value in the alice and bob example
	public int calculatePersonalKey(int secretInteger){
		return (int)(Math.pow(g, secretInteger) % p);
	}
	
	//the s value in the alice and bob example. The shared secret key.
	public int calculateSharedKey(int receivedPersonalKey, int secretInteger){
		return (int)(Math.pow(receivedPersonalKey, secretInteger) % p);
	}
	
	
}
