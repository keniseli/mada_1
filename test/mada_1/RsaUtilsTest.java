package mada_1;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class RsaUtilsTest {
	
	@Test
	public void testSquareAndMultiply_1() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("13"), 6);
		Assert.assertEquals("62", result);
	}

	
	@Test
	public void testSquareAndMultiply_4() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("11"), new BigInteger("36"), 5);
		Assert.assertEquals("5", result);
	}
	
	@Test
	public void testSquareAndMultiply_3() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("23"), 115);
		Assert.assertEquals("62", result);
	}
	@Test
	public void testSquareAndMultiply_2() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("11"), new BigInteger("25"), 9);
		Assert.assertEquals("1", result);
	}
	
	@Test
	public void testCalculatePhi() {
		BigInteger phi = RsaUtils.calculatePhi(new BigInteger("77"));
		Assert.assertEquals(new BigInteger("60"), phi);
	}
}
