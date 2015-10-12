package mada;

import java.math.BigInteger;
import java.util.HashMap;

public class RsaUtils {

	/**
	 * Performs fast exponentiation.
	 * 
	 * @return the outcome of the fast exponentiation: <i>x<sup>e</sup>mod d</i>
	 */
	public static String squareAndMultiply(BigInteger modulus, BigInteger e, BigInteger x) {
		BigInteger ergebnis = BigInteger.ONE;
		BigInteger faktor = new BigInteger(x.toString());

		String bits = e.toString(2);
		int length = bits.length();
		char[] bitsArray = bits.toCharArray();

		for (int i = length - 1; i >= 0; i--) {
			if (i != length - 1) {
				faktor = faktor.pow(2).mod(modulus);
			}
			boolean isSet = bitsArray[i] == '1';
			if (isSet) {
				ergebnis = ergebnis.multiply(faktor).mod(modulus);
			}
		}

		return ergebnis.toString();
	}

	public static BigInteger euklid(BigInteger m, BigInteger e) {
		BigInteger x0, x1, y0, y1, q = null, r = null, x0_tmp, y0_tmp;
		BigInteger a = new BigInteger(m.toString());
		BigInteger b = new BigInteger(e.toString());
		x0 = BigInteger.valueOf(1);
		y0 = BigInteger.valueOf(0);
		x1 = BigInteger.valueOf(0);
		y1 = BigInteger.valueOf(1);

		while ((b.compareTo(BigInteger.ZERO)) != 0) {
			q = a.divide(b);
			r = a.mod(b);
			System.out.println(String.format("%s  %s  %s  %s  %s  %s  %s  %s", a, b, x0, y0, x1, y1, q, r));
			a = new BigInteger(b.toString());
			b = new BigInteger(r.toString());
			x0_tmp = new BigInteger(x0.toString());
			y0_tmp = new BigInteger(y0.toString());
			x0 = new BigInteger(x1.toString());
			y0 = new BigInteger(y1.toString());
			x1 = x0_tmp.subtract(q.multiply(x1));
			y1 = y0_tmp.subtract(q.multiply(y1));
		}
		System.out.println(String.format("%s  %s  %s  %s  %s  %s  %s  %s", a, b, x0, y0, x1, y1, q, r));
		if (y0.signum() == -1) {
			y0 = y0.add(m);
		}
		return y0;
	}

	public static BigInteger getGCD(BigInteger n, BigInteger e) {
		BigInteger rest = null;
		BigInteger gcd = new BigInteger(e.toString());

		while (n.compareTo(BigInteger.ZERO) != 0) {
			rest = gcd.mod(n);
			gcd = n;
			n = rest;
		}
		return gcd;
	}

	public static HashMap<BigInteger, BigInteger> getPrimeFactors(BigInteger n, BigInteger[] primes,
			HashMap<BigInteger, BigInteger> primeFactors) {
		if (arrayContains(primes, n)) {
			return primeFactors;
		}
		for (int i = 0; i < primes.length; i++) {
			BigInteger prime = primes[i];
			if (n.mod(prime) == BigInteger.ZERO) {
				BigInteger exponent = primeFactors.get(prime);
				if (exponent == null) {
					exponent = BigInteger.ZERO;
				}
				BigInteger newExponent = exponent.add(BigInteger.ONE);
				primeFactors.put(prime, newExponent);
				BigInteger nextN = n.divide(prime);
				if (nextN.equals(BigInteger.ONE)) {
					return primeFactors;
				}
				primeFactors = getPrimeFactors(nextN, primes, primeFactors);
			}
		}
		return primeFactors;
	}

	private static boolean arrayContains(BigInteger[] primes, BigInteger n) {
		for (BigInteger prime : primes) {
			if (prime.equals(n)) {
				return true;
			}
		}
		return false;
	}

}