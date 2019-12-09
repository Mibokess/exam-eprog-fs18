package exercises;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mikeb on 12/9/2019
 */
class WarenAnalyseTest {

	@Test
	void analyse() throws FileNotFoundException {
		var inputFile = new File("transaktionen.txt");
		var outputFile = new File("resultWarenAnalyse.txt");

		WarenAnalyse.analyse(inputFile, outputFile);

		var scanner = new Scanner(outputFile);
		assertEquals("US-Tastatur 24.95", scanner.nextLine());
		assertEquals("Luigi 2135.05", scanner.nextLine());
		assertEquals("Cape", scanner.nextLine());
	}
}