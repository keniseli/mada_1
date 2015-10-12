package mada;

import java.math.BigInteger;
import java.util.Random;

public class KeyGenerator {
	private static final int BIT_LENGTH = 1024;
	private BigInteger n;
	private BigInteger e;
	private BigInteger d;
	private BigInteger p;
	private BigInteger q;

	public KeyGenerator() {
		n = createN();
		e = defineE(n);
		d = defineD(n);
	}

	private BigInteger defineD(BigInteger n2) {
		BigInteger m = getPhi();
		BigInteger d = RsaUtils.euklid(m, e);
		return d;
	}

	private BigInteger createN() {
		// create a random object
		Random randomNumber_1 = new Random();
		Random randomNumber_2 = new Random();

		// create two Primzahlen
		p = BigInteger.probablePrime(BIT_LENGTH, randomNumber_1);
		q = BigInteger.probablePrime(BIT_LENGTH, randomNumber_2);

		// create n
		BigInteger n = p.multiply(q);

		return n;
	}

	private BigInteger defineE(BigInteger n) {
		System.out.println(n);
		BigInteger e = BigInteger.probablePrime(BIT_LENGTH, new Random());
		BigInteger m = getPhi();
		BigInteger gcd = RsaUtils.getGCD(m, e);
		while (gcd.compareTo(BigInteger.ONE) != 0) {
			e = e.add(BigInteger.ONE);
			gcd = RsaUtils.getGCD(m, e);
		}
		return e;
	}

	private BigInteger getPhi() {
		return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getP() {
		return p;
	}

	public BigInteger getQ() {
		return q;
	}

	public BigInteger getD() {
		return d;
	}

	public BigInteger getE() {
		return e;
	}

}
