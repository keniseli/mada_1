package mada_1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.doTheRsa();
	}

	private void doTheRsa() {
		// TODO generate tuples

		// encrypt text.txt in chiffre.txt
		Tuple tupleFromFile = getTupleFromFile("/pk.txt");
		String plainText = readContentFromFile("/text.txt");
		File tempFile = encrypt(tupleFromFile, plainText);

		// String chiffreFile = tempFile.getName();
		
		
		// TODO decrypt chiffre.txt
		File chiffreFile = new File("/chiffre.txt");
		Tuple tupleFromPrivateKey = getTupleFromFile("/sk.txt");
		String chiffreText = readContentFromFile(tempFile.getAbsolutePath());
		boolean done = decrypt(tupleFromPrivateKey, chiffreText);
		
	}

	private Tuple getTupleFromFile(String keyFileName) {
		List<String> lines = readLinesFromFile(keyFileName);
		int numberOfLines = lines.size();
		if (numberOfLines != 1) {
			String message = String.format("Expected 1 line (with 1 key) from file [%s] but got [%s].", keyFileName,
					numberOfLines);
			throw new RuntimeException(message);
		}
		Tuple key = Tuple.parseTuple(lines.get(0));
		return key;
	}

	private String readContentFromFile(String fileName) {
		List<String> readLinesFromFile = readLinesFromFile(fileName);
		String content = "";
		for (String line : readLinesFromFile) {
			content = String.format("%s%s", content, line);
		}
		return content;
	}
	
	private List<String> readLinesFromFile(String fileName) {
		File file =  new File(fileName);
		if (!file.exists()) {
			file = new File(getClass().getResource(fileName).getFile());
		}
		List<String> lines = FileUtils.readFromFile(file);
		return lines;
	}

	private File encrypt(Tuple tupleFromFile, String plainText) {
		Encryptor encryptor = new Encryptor();
		String chiffreText = encryptor.encrypt(tupleFromFile, plainText);

		File tempFile = null;
		try {
			//tempFile = File.createTempFile("chiffre", ".txt");
			tempFile = new File("chiffre.txt");
			ArrayList<String> lines = new ArrayList<String>();
			lines.add(chiffreText);
			OpenOption[] options = new OpenOption[0];
			Files.write(tempFile.toPath(), lines, options);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return tempFile;
	}
	
	private boolean decrypt(Tuple tuplePrivateKey, String chiffreText) {
		Decryptor decryptor = new Decryptor();
		String plainText = decryptor.decrypt(tuplePrivateKey, chiffreText);
		System.out.println(plainText);
		
		return true;
	}
}
