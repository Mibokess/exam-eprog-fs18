package solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mikeb on 12/3/2019
 */
class Kombinationen {
	static String generate(String s) {
		return String.join(" ", generate(s, ""));
	}

	private static Set<String> generate(String s, String current) {
		if (s.isEmpty()) return new HashSet<>(List.of(current));

		Set<String> withOut = generate(s.substring(1), current);
		Set<String> with = generate(s.substring(1), current + s.charAt(0));

		withOut.addAll(with);
		return withOut;
	}
}
