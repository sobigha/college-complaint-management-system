package project;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.regex.*;;

public class password {
	public String encrypt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//Setting SHA-1 Algorithm For encryption
	    MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	    
	    //Calculating byte length with UTF-8 Encoding
	    crypt.update(password.getBytes("UTF-8"));
	    byte[] messageDigest = crypt.digest(); 
	    
	    //Converting bytes to checksum
	    BigInteger hash = new BigInteger(1, messageDigest);

	    //Hex hash is converted to string
	    return hash.toString(16);
	}
	
	public String regexString(String passwd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		/* Minimum Length = 8
		 * One UpperCase Letter
		 * One LowerCase Letter
		 * One Digit
		 * One Special Character
		 * 
		 * (?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$
		 */
		
		String regexString = "^(?=.*[A-Z].)(?=.*[!@#$&*])(?=.*[0-9].)(?=.*[a-z].*[a-z].*[a-z]).{8,}$";
		
		//Create a Pattern String
		Pattern r = Pattern.compile(regexString);
		
		//Create a matcher string
		Matcher m = r.matcher(passwd);
		
		//Find password matches 
		Boolean bool = new Boolean(m.find());
		
		if(bool==false) {
			return "Password Did not match the requirement";
		}
		return encrypt(passwd);
	}
}
