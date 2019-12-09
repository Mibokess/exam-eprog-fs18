package exercises.aufgabe4;

import java.util.*;

/**
 * Created by mikeb on 12/9/2019
 */
public class City {
	public static void main(String[] args) {
		var builder = new CityBuilder();
		var zurich = builder.build();

		var squares = zurich.reachableSquares("Central", 9);
		int x = 5;
	}

	private List<Intersection> intersections;

	City(List<Intersection> intersections) {
		this.intersections = intersections;
	}

	private List<Street> getDeadEnds() {
		return null;
	}

	private Set<Square> reachableSquares(String squareName, int distance) {
		return null;
	}
}
