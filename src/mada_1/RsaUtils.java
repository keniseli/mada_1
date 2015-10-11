package mada_1;

import java.math.BigInteger;

public class RsaUtils {

	/**
	 * Performs fast exponentiation.
	 * 
	 * @return the outcome of the fast exponentiation: <i>x<sup>e</sup>mod d</i>
	 */
	public static String squareAndMultiply(BigInteger m, BigInteger e, int x) {

		BigInteger h = BigInteger.ONE;
		BigInteger k = new BigInteger(String.valueOf(x));
		for (int i = e.bitLength() - 2; i >= 0; i--) {
			boolean isSet = e.testBit(i);
			if (isSet) {
				h = h.multiply(k).mod(m);
			}
			k = k.multiply(k).mod(m);
		}
		h = h.multiply(k).mod(m);

		return h.toString();
	}

	public static BigInteger calculatePhi(BigInteger n) {
		
		return null;
	}
	
	
}
