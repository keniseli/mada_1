package mada_1;

import java.math.BigInteger;

public class Decryptor {

	public String decrypt(Tuple tuplePrivateKey, String chiffreText) {
		StringBuilder decryptedStringBuilder  = new StringBuilder();
		BigInteger n = tuplePrivateKey.getFirstElement();
		BigInteger d = tuplePrivateKey.getSecondElement();
		
		String[] chiffreElementsArray = chiffreText.split(",");
		
		for (String element : chiffreElementsArray) {
			String decrypted = RsaUtils.squareAndMultiply(n, d, Integer.parseInt(element));
			int value = Integer.parseInt(decrypted);
			char character = (char) value;
			decryptedStringBuilder.append(character);
		}
		
		return decryptedStringBuilder.toString();
	}

}
