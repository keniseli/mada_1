package mada;

import java.math.BigInteger;

/**
 * Implements an RSA encryption:<br />
 * <i>x &#8712; {0, 1, ..., n-1}: x<sup>e</sup> mod n</i><br />
 * Where<br />
 * <i>x</i>: the message to be encrypted<br />
 * <i>n</i>: the first part of the public key<br />
 * <i>e</i>: the second part of the public key<br />
 *
 */
public class Encryptor {

	/**
	 * Encrypts the given plainText using the given tuple and returns a comma
	 * separated String with numbers representing each one character of the
	 * plainText.
	 * 
	 */
	public String encrypt(Tuple tuple, String plainText) {
		StringBuilder encryptedTextBuilder = new StringBuilder();
		BigInteger n = tuple.getFirstElement();
		BigInteger e = tuple.getSecondElement();
		for (char character : plainText.toCharArray()) {
			int characterNumber = (int) character;
			String encrypted = RsaUtils.squareAndMultiply(n, e, new BigInteger(String.valueOf(characterNumber)));
			if (encryptedTextBuilder.length() > 0) {
				encryptedTextBuilder.append(",");
			}
			encryptedTextBuilder.append(encrypted);
		}
		return encryptedTextBuilder.toString();

	}

}
