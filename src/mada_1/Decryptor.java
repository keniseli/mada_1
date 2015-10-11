package mada_1;

import java.math.BigInteger;

public class Decryptor {

	public String decrypt(Tuple tuplePrivateKey, String chiffreText) {
		StringBuilder decryptedStringBuilder  = new StringBuilder();
		BigInteger n = tuplePrivateKey.getFirstElement();
		BigInteger d = tuplePrivateKey.getSecondElement();
		
		String[] chiffreElementsArray = chiffreText.split(",");
		
		for (String element : chiffreElementsArray) {
			System.out.println(element);
			System.out.println(Integer.parseInt(element));
			String decrypted = RsaUtils.squareAndMultiply(n, d, Integer.parseInt(element));
			System.out.println(decrypted);
			decryptedStringBuilder.append(decrypted);
		}
		
		return decryptedStringBuilder.toString();
	}

}
