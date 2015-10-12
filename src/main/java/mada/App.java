package mada;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

public class App {
	private static final String CHIFFRE_TEXT_FILE_NAME = "/chiffre.txt";
	private static final String PRIVATE_KEY_FILE_NAME = "/sk.txt";
	private static final String PUBLIC_KEY_FILE_NAME = "/pk.txt";
	private static final String TEXT_FILE_NAME = "/text.txt";
	private FileUtils fileUtils = new FileUtils();

	public static void main(String[] args) {
		App app = new App();
		app.doTheRsa();
	}

	private void doTheRsa() {
		// TODO generate tuples
		KeyGenerator generator = new KeyGenerator();
		BigInteger n = generator.getN();
		BigInteger e = generator.getE();
		Tuple generatedPublicKey = new Tuple(n, e);
		File publicKeyFile = fileUtils.getFileFromClassPath(PUBLIC_KEY_FILE_NAME);
		fileUtils.writeToFile(publicKeyFile, generatedPublicKey.toString());
		File privateKeyFile = fileUtils.getFileFromClassPath(PRIVATE_KEY_FILE_NAME);
		BigInteger d = generator.getD();
		Tuple generatedPrivateKey = new Tuple(n, d);
		fileUtils.writeToFile(privateKeyFile, generatedPrivateKey.toString());

		// encrypt text.txt in chiffre.txt
		Tuple publicKey = getTupleFromFile(PUBLIC_KEY_FILE_NAME);
		File textFile = fileUtils.getFileFromClassPath(TEXT_FILE_NAME);
		String plainText = fileUtils.readContentFromFile(textFile);
		String encrypted = encrypt(publicKey, plainText);

		File chiffreFile = fileUtils.getFileFromClassPath(CHIFFRE_TEXT_FILE_NAME);
		Tuple privateKey = getTupleFromFile(PRIVATE_KEY_FILE_NAME);
		String chiffreText = fileUtils.readContentFromFile(chiffreFile);
		String decrypted = decrypt(privateKey, chiffreText);
		System.out.println(plainText + " - " + encrypted + " - " + decrypted);
	}

	private Tuple getTupleFromFile(String keyFileName) {
		List<String> lines = fileUtils.readLinesFromFile(keyFileName);
		int numberOfLines = lines.size();
		if (numberOfLines != 1) {
			String message = String.format("Expected 1 line (with 1 key) from file [%s] but got [%s].", keyFileName,
					numberOfLines);
			throw new RuntimeException(message);
		}
		Tuple key = Tuple.parseTuple(lines.get(0));
		return key;
	}

	private String encrypt(Tuple tuple, String plainText) {
		Encryptor encryptor = new Encryptor();
		String chiffreText = encryptor.encrypt(tuple, plainText);

		File file = fileUtils.getFileFromClassPath(CHIFFRE_TEXT_FILE_NAME);
		fileUtils.writeToFile(file, chiffreText);
		return chiffreText;
	}

	private String decrypt(Tuple privateKey, String chiffreText) {
		Decryptor decryptor = new Decryptor();
		String plainText = decryptor.decrypt(privateKey, chiffreText);
		return plainText;
	}
}
