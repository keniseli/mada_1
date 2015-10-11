package mada;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mada.KeyGenerator;
import mada.RsaUtils;

public class KeyGeneratorTest {
	KeyGenerator keygen;

	@Before
	public void setUp() {
		keygen = new KeyGenerator();
	}

	@Test
	public void createBigInteger() {

	}

	@Test
	public void getGGT() {
		BigInteger a = BigInteger.valueOf(6);
		BigInteger b = BigInteger.valueOf(8);
		BigInteger ggt = RsaUtils.getGCD(a, b);
		Assert.assertEquals(new BigInteger("2"), ggt);
	}

	@Test
	public void defineE() {

	}

	@Test
	public void calculateD() {

	}

}
