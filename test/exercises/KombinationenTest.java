package exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mikeb on 12/9/2019
 */
class KombinationenTest {

	@Test
	void generate() {
		String s = "12a";
		String expected = " 1 2 a 12 1a 2a 12a";
		String actual = Kombinationen.generate(s);

		assertTrue(Arrays.stream(expected.split(" ")).allMatch(actual::contains));
		assertEquals(expected.length(), actual.length());
	}
}