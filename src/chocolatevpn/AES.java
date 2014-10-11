package chocolatevpn;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


//MIGHT NEED TO RENAME PARAMETERS
public class AES {

	//static String plainText = "chocolatevpn mmm"; // 16 char
	//static String encryptionKey = "chocolatevpn key"; // 16 char key for encryptions
	static String initialVector = "16 bytes o cocoa"; // initial vector must be 16 bytes long

	public static byte[] encrypt (String plainText, String encryptionKey){

		plainText = padStringToBe16Bytes(plainText);

		try{
			return initAES (Cipher.ENCRYPT_MODE, plainText.getBytes("UTF-8"), encryptionKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static byte[] initAES (int mode, byte[] text, String cipherKey) throws Exception{

		cipherKey = padStringToBe16Bytes(cipherKey);

		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding"); //AES, in CBC, inputs padded above
		SecretKeySpec key = new SecretKeySpec(cipherKey.getBytes("UTF-8"), "AES");
		cipher.init(mode, key, new IvParameterSpec(initialVector.getBytes("UTF-8")));

		return cipher.doFinal(text);
	}

	public static String decrypt (byte[] cipherText, String decryptionKey) {
		
		try{
			byte[] decryptedBytes = initAES (Cipher.DECRYPT_MODE, cipherText, decryptionKey);
			return new String(decryptedBytes, "UTF-8").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String padStringToBe16Bytes (String str){
		while(str.length() % Constants.AES_LENGTH != 0)
			str += '\0';
		return str;
	}
}