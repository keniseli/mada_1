package mada_1;

import java.math.BigInteger;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class RsaUtilsTest {

	@Test
	public void testSquareAndMultiply_77_1() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("13"), 75);
		Assert.assertEquals("47", result);
	}

	@Test
	public void testSquareAndMultiply_77_2() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("37"), 47);
		Assert.assertEquals("75", result);
	}

	@Test
	public void testSquareAndMultiply_11_1() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("11"), new BigInteger("13"), 7);
		Assert.assertEquals("2", result);
	}

	@Test
	public void testSquareAndMultiply_1_209() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("209"), new BigInteger("77"), 50);
		Assert.assertEquals("8", result);
	}

	@Test
	public void testSquareAndMultiply_2_209() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("209"), new BigInteger("173"), 8);
		Assert.assertEquals("50", result);
	}

	@Test
	public void testSquareAndMultiply_1_143() {
		char character = 'a';
		String result = RsaUtils.squareAndMultiply(new BigInteger("143"), new BigInteger("7"), character);
		Assert.assertEquals("59", result);
	}

	@Test
	public void testSquareAndMultiply_2_143() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("143"), new BigInteger("103"), 59);
		Assert.assertEquals("97", result);
	}

	@Test
	public void testEuklid() {
		BigInteger euklid = RsaUtils.euklid(new BigInteger("50"), new BigInteger("17"));
		Assert.assertEquals(new BigInteger("3"), euklid);
	}

	@Test
	public void testPhi77() {
		BigInteger phi = RsaUtils.getPhi(new BigInteger("77"));
		Assert.assertEquals(new BigInteger("60"), phi);
	}

	@Test
	public void testPhi143() {
		BigInteger phi = RsaUtils.getPhi(new BigInteger("143"));
		Assert.assertEquals(new BigInteger("120"), phi);
	}

	@Test
	public void testPrimeFactorization15() {
		BigInteger[] primes = RsaUtils.doTheSieve(new BigInteger("15"));
		HashMap<BigInteger, BigInteger> primeFactors = new HashMap<BigInteger, BigInteger>();
		primeFactors = RsaUtils.getPrimeFactors(new BigInteger("15"), primes, primeFactors);

		HashMap<BigInteger, BigInteger> expectation = new HashMap<BigInteger, BigInteger>();
		expectation.put(new BigInteger("3"), new BigInteger("1"));
		expectation.put(new BigInteger("5"), new BigInteger("1"));

		Assert.assertEquals(expectation, primeFactors);
	}

	@Test
	public void testPrimeFactorization77() {
		BigInteger[] primes = RsaUtils.doTheSieve(new BigInteger("77"));
		HashMap<BigInteger, BigInteger> primeFactors = new HashMap<BigInteger, BigInteger>();
		primeFactors = RsaUtils.getPrimeFactors(new BigInteger("77"), primes, primeFactors);

		HashMap<BigInteger, BigInteger> expectation = new HashMap<BigInteger, BigInteger>();
		expectation.put(new BigInteger("7"), new BigInteger("1"));
		expectation.put(new BigInteger("11"), new BigInteger("1"));

		Assert.assertEquals(expectation, primeFactors);
	}

}
