package misc;

import org.apache.commons.codec.binary.Base64;
import java.util.Iterator;

import org.testng.annotations.Test;

public class Misc {
	@Test
	public void base64Convertion() {
		String userPass = "user and pass";
		String afterencodingString = Base64.encodeBase64String(userPass.getBytes());
		System.out.println(userPass.getBytes());
		for(byte b : userPass.getBytes()) {
			System.out.println(b);
		}
		System.out.println(afterencodingString);
		byte[] afterDecode = Base64.decodeBase64(afterencodingString.getBytes());
		System.out.println(new String(afterDecode));
	}

}
