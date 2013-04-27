package com.test.build;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestFileCreation {
	private final String DIR_PATH = "some-dir/target/generated-resources/stuff.xml";

	@Test
	public void createDirectoryTest() throws IOException {
		try {
			File targetFile = new File(DIR_PATH);
			File parent = targetFile.getParentFile();

			if (!parent.exists() && !parent.mkdirs()) {
				throw new IllegalStateException("Couldn't create dir: " + parent);
			}
		} catch (Exception exception) {
			String errorMessage = "Error writing to file: " + DIR_PATH + "with the following error: "
					+ exception.getMessage();
			throw new RuntimeException(errorMessage, exception);
		}
	}



}
