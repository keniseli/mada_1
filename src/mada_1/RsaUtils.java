package mada_1;

import java.math.BigInteger;

public class RsaUtils {

	/**
	 * Performs fast exponentiation.
	 * 
	 * @return the outcome of the fast exponentiation: <i>x<sup>e</sup>mod d</i>
	 */
	public static String squareAndMultiply(BigInteger d, BigInteger e, char x) {

		BigInteger h = BigInteger.ONE;
		Character characterAsNumber = Character.valueOf(x);
		String characterNumberAsString = String.valueOf(characterAsNumber);
		BigInteger k = new BigInteger(characterNumberAsString);
		for (int i = e.bitLength() - 2; i >= 0; i--) {
			boolean isSet = e.testBit(i);
			if (isSet) {
				h = h.multiply(k).mod(d);
			}
			k = k.multiply(k).mod(d);
		}
		h = h.multiply(k).mod(d);

		return h.toString();
	}
}
