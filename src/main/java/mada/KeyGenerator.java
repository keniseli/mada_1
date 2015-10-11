package mada;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
	private BigInteger n;
	private BigInteger e;

	public KeyGenerator() {
		n = createN();
		e = defineE(n);
	}

	private BigInteger createN() {
		// create a BigInteger object
		BigInteger firstBigInteger = null;
		BigInteger secondBigInteger = null;

		// create and assign value to bitLength
		int bitLength = 1024;

		// create a random object
		Random randomNumber_1 = new Random();
		Random randomNumber_2 = new Random();

		// create two Primzahlen
		firstBigInteger = BigInteger.probablePrime(bitLength, randomNumber_1);
		secondBigInteger = BigInteger.probablePrime(bitLength, randomNumber_2);

		// create n
		BigInteger n = firstBigInteger.multiply(secondBigInteger);

		return n;
	}

	private BigInteger defineE(BigInteger n) {
//		System.out.println(n);
		BigInteger e = BigInteger.valueOf(1000);
		BigInteger gcd = RsaUtils.getGCD(n, e);
		while (gcd.compareTo(BigInteger.ONE) != 0) {
			e.add(BigInteger.ONE);
		}
		return e;
	}

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}
}
