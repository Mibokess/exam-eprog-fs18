package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mikeb on 12/9/2019
 */
class AbstandTest {

	@Test
	void abstand() {
		var ms = new int[]{1, -2, 0, 3};
		var ns = new int[]{1, 4, -5, 3, 7};

		assertEquals(18, Abstand.abstand(ms, ns));
	}
}