package mada;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class RsaUtilsTest {

	@Test
	public void testSquareAndMultiply_77_1() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("13"), new BigInteger("75"));
		Assert.assertEquals("47", result);
	}

	@Test
	public void testSquareAndMultiply_77_2() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("37"), new BigInteger("47"));
		Assert.assertEquals("75", result);
	}

	@Test
	public void testSquareAndMultiply_11_1() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("11"), new BigInteger("13"), new BigInteger("7"));
		Assert.assertEquals("2", result);
	}

	@Test
	public void testSquareAndMultiply_1_209() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("209"), new BigInteger("77"), new BigInteger("50"));
		Assert.assertEquals("8", result);
	}

	@Test
	public void testSquareAndMultiply_2_209() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("209"), new BigInteger("173"), new BigInteger("8"));
		Assert.assertEquals("50", result);
	}

	@Test
	public void testSquareAndMultiply_1_143() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("143"), new BigInteger("7"), new BigInteger("97"));
		Assert.assertEquals("59", result);
	}

	@Test
	public void testSquareAndMultiply_2_143() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("143"), new BigInteger("103"), new BigInteger("59"));
		Assert.assertEquals("97", result);
	}

	@Test
	public void testEuklid50() {
		BigInteger euklid = RsaUtils.euklid(new BigInteger("50"), new BigInteger("17"));
		Assert.assertEquals(new BigInteger("3"), euklid);
	}
	
	@Test
	public void testEuklid209() {
		BigInteger euklid = RsaUtils.euklid(new BigInteger("300"), new BigInteger("111"));
		Assert.assertEquals(new BigInteger("273"), euklid);
	}
	
	@Test
	public void testEuklid() {
		BigInteger p = new BigInteger("83");
		BigInteger q = new BigInteger("11");
		BigInteger n = p.multiply(q);
		BigInteger euklid = RsaUtils.euklid(n, new BigInteger("77"));
		Assert.assertEquals(new BigInteger("12"), euklid);
	}
}
