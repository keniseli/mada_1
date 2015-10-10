package mada_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Does the reading/writing from and to files.
 *
 */
public class FileUtils {

	public static List<String> readFromFile(File file) {
		if (file == null) {
			throw new RuntimeException("A file must be provided but was [null].");
		}
		try {
			List<String> lines = Files.lines(file.toPath()).collect(Collectors.toList());
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
			String message = String.format("Could not read from [%s]", file.getName());
			throw new RuntimeException(message);
		}
	}

}
