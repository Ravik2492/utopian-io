package beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class EncryptionDecryption {
	    
	    public String encrypt(String value) throws Exception
	    {
	        Key key = generateKey();
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	        byte [] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
	        String encryptedValue64 = new BASE64Encoder().encode(encryptedByteValue);
	        return encryptedValue64;	               
	    }
	    
	    public String decrypt(String value) throws Exception
	    {
	        Key key = generateKey();
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, key);
	        byte [] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
	        byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
	        String decryptedValue = new String(decryptedByteValue,"utf-8");
	        return decryptedValue;  
	    }
	
	 private Key generateKey() throws Exception 
	    {
	        Key key = new SecretKeySpec(getKeyBytes(),"AES");
	        return key;
	    }
	 
	 public byte[] getKeyBytes() throws IOException
	 {
		 	File file = new File("src/resources/key.properties");
			FileInputStream fileInput = new FileInputStream(file);
		 	Properties props = new Properties();		 	
		 	props.load(fileInput);
		 	String bytekey = props.getProperty("bytekey");
		 	//System.out.println("BYTEKEYYYYYYY: "+bytekey);
		 	return bytekey.getBytes();
	 }
	 
	 public byte[] getSecureRandomPassword() throws NoSuchAlgorithmException
	 {
		 	 SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");		 
		     byte[] randomBytes = new byte[128];		 
		     secureRandomGenerator.nextBytes(randomBytes);
		     int seedByteCount = 5;
		     byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);
		     return seed;
	 }
}
