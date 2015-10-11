package mada_1;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EncryptorTest {

	private Encryptor encryptor;

	@Before
	public void setUp() {
		encryptor = new Encryptor();
	}

	@Test
	public void testEncryption6() {
		String encrypt = encryptor.encrypt(new Tuple(new BigInteger("77"), new BigInteger("13")), "6");
		Assert.assertEquals("62", encrypt);
	}
	
	@Test
	public void testEncryptionSomeText() {
		Tuple tuple = new Tuple(new BigInteger("77"), new BigInteger("13"));
		String encrypt = encryptor.encrypt(tuple, "some");
		Assert.assertEquals("62", encrypt);
	}
	
}
