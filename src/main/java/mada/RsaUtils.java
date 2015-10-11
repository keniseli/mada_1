package mada;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class RsaUtils {

	/**
	 * Performs fast exponentiation.
	 * 
	 * @return the outcome of the fast exponentiation: <i>x<sup>e</sup>mod d</i>
	 */
	public static String squareAndMultiply(BigInteger modulus, BigInteger e, int x) {
		BigInteger ergebnis = BigInteger.ONE;
		BigInteger faktor = new BigInteger(String.valueOf(x));

		String bits = bits(e);
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

	private static String bits(BigInteger bigInteger) {
		StringBuilder binaryStringBuilder = new StringBuilder();
		BigInteger two = new BigInteger("2");

		while (!bigInteger.equals(BigInteger.ZERO)) {
			char c = (char) bigInteger.mod(two).add(new BigInteger("48")).intValue();
			binaryStringBuilder.insert(0, c);
			bigInteger = bigInteger.divide(two);
		}
		return binaryStringBuilder.toString();
	}

	public static BigInteger euklid(BigInteger n, BigInteger e) {
		// declarations
		BigInteger x0, x1, y0, y1, q, r, x0_tmp, y0_tmp;
		BigInteger a = new BigInteger(n.toString());
		BigInteger b = new BigInteger(e.toString());
		x0 = BigInteger.valueOf(1);
		y0 = BigInteger.valueOf(0);
		x1 = BigInteger.valueOf(0);
		y1 = BigInteger.valueOf(1);
		String result = null;

		// euklidischer Algorithmus
		while ((b.compareTo(BigInteger.ZERO)) != 0) {
			q = a.divide(b);
			r = a.mod(b);
			a = b;
			b = r;
			x0_tmp = x1;
			y0_tmp = y1;
			x1 = x0.subtract(q.multiply(x1));
			y1 = y0.subtract(q.multiply(y1));
			x0 = x0_tmp;
			y0 = y0_tmp;

			result = String.format("(%s,%s)", x0.toString(), y0.toString());
			System.out.println(result);
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

	/**
	 * Calculates phi of the given n.<br />
	 * phi(n) = (prime1 - 1) * prime1<sup>e1-1</sup> + (prime 2 - 1) * prime2
	 * <sup>e2-1</sup> ... (primeN - 1) * primeN<sup>eN-1</sup>
	 * 
	 */
	public static BigInteger getPhi(BigInteger n) {
		BigInteger result = BigInteger.ONE;

		BigInteger[] primes = doTheSieve(n.subtract(BigInteger.ONE));

		HashMap<BigInteger, BigInteger> primeFactors = new HashMap<>();
		primeFactors = getPrimeFactors(n, primes, primeFactors);
		for (Entry<BigInteger, BigInteger> entry : primeFactors.entrySet()) {
			BigInteger base = entry.getKey();
			BigInteger exponent = entry.getValue();
			result = result.multiply((base.subtract(BigInteger.ONE)).multiply(base.pow(exponent.intValue() - 1)));
		}
		return result;
	}

	public static BigInteger[] doTheSieve(BigInteger sizeOfSieve) {
		List<BigInteger> primes = new ArrayList<>();
		BigInteger i = new BigInteger("2");
		while (i.compareTo(sizeOfSieve) < 1) {
			if (isPrime(i, primes)) {
				primes.add(i);
			}
			i = i.add(BigInteger.ONE);
		}
		return primes.toArray(new BigInteger[primes.size()]);
	}

	private static boolean isPrime(BigInteger possiblePrime, List<BigInteger> knownPrimes) {
		for (BigInteger prime : knownPrimes) {
			if (possiblePrime.mod(prime) == BigInteger.ZERO) {
				return false;
			}
		}
		return true;
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