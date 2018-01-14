package beans;

import java.security.NoSuchAlgorithmException;

public class SaltedMD5String {
	
	public String getSecureHasPassword(String haspass) throws NoSuchAlgorithmException
	{
		byte saltedbytes[] = getSalt(haspass);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < saltedbytes.length; ++i) 
		{
	          sb.append(Integer.toHexString((saltedbytes[i] & 0xFF) | 0x100).substring(1,3));
	    }
		return sb.toString();
	}
	
	public byte[] getSalt(String haspass) throws NoSuchAlgorithmException
	{
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		byte[] array = md.digest(haspass.getBytes());
		return array;
	}
}
