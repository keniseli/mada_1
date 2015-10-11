package mada_1;

import java.math.BigInteger;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class RsaUtilsTest {
	
	@Test
	public void testSquareAndMultiply_1() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("13"), 6);
		Assert.assertEquals("62", result);
	}

	@Test
	public void testSquareAndMultiply_2() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("11"), new BigInteger("25"), 9);
		Assert.assertEquals("1", result);
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
