package beans;

public class Test {

	public static void main(String[] args) throws Exception {
		
		SaltedMD5String saltedmd5string = new SaltedMD5String();
		EncryptionDecryption encypdecryp = new EncryptionDecryption();
		Login login = new Login();
		
		//System.out.println("LOGIN: "+login.findSession());
		//System.out.println("LOGIN: "+login.getSetting());
		System.out.println("SLATED MD5: "+saltedmd5string.getSecureHasPassword("Administrator"));
		System.out.println("GETSECURERANDOM: "+encypdecryp.getSecureRandomPassword());
		System.out.println("ENCRPTION: "+encypdecryp.encrypt("ravi"));
		System.out.println("DECRYPTION: "+encypdecryp.decrypt("ravi"));

	}
}