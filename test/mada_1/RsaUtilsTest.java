package mada_1;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class RsaUtilsTest {
	
	@Test
	public void testSquareAndMultiply_1() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("77"), new BigInteger("13"), '6');
		Assert.assertEquals("62", result);
	}

	@Test
	public void testSquareAndMultiply_2() {
		String result = RsaUtils.squareAndMultiply(new BigInteger("11"), new BigInteger("25"), '9');
		Assert.assertEquals("1", result);
	}
}
