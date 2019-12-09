package solutions;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mikeb on 12/3/2019
 */
class Abstand {
	static int abstand(int[] ms, int[] ns) {
		int absoluteDifference = 0;

		for (int i = 0; i < Math.max(ms.length, ns.length); i++) {
			int msValue = ms.length > i ? ms[i] : 0;
			int nsValue = ns.length > i ? ns[i] : 0;

			absoluteDifference += Math.abs(msValue - nsValue);
		}

		return absoluteDifference;
	}
}
