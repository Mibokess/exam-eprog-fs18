package solutions.aufgabe4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		var deadEnds = new HashSet<Street>();
		var allDeadEndsIntersections = new HashSet<Intersection>();
		int sizeDeadEnds;

		do {
			sizeDeadEnds = deadEnds.size();

			boolean allDeadEnds = true;
			for (Intersection intersection : intersections) {
				for (Street outgoingStreet : intersection.outgoingStreets) {
					if (allDeadEndsIntersections.contains(outgoingStreet.to) || outgoingStreet.to.outgoingStreets.size() == 0) {
						deadEnds.add(outgoingStreet);
						continue;
					}

					allDeadEnds = false;
				}

				if (allDeadEnds) allDeadEndsIntersections.add(intersection);
			}
		} while (sizeDeadEnds != deadEnds.size());

		return new ArrayList<>(deadEnds);
	}

	private Set<Square> reachableSquares(String squareName, int distance) {
		if (distance < 0) throw new IllegalArgumentException();

		Intersection originIntersection = null;
		for (Intersection intersection : intersections) {
			if (intersection instanceof Square && ((Square) intersection).name.equals(squareName)) {
				originIntersection = intersection;
				break;
			}
		}

		if (originIntersection == null) throw new IllegalArgumentException();

		var reachableSquares = new HashSet<Square>();
		reachableSquares(originIntersection, distance, reachableSquares);
		reachableSquares.remove(originIntersection);

		return reachableSquares;
	}

	private void reachableSquares(Intersection intersection, int distance, Set<Square> reachableSquares) {
		if (distance < 0) return;

		if (intersection instanceof Square) {
			reachableSquares.add((Square) intersection);
		}

		for (Street outgoingStreet : intersection.outgoingStreets) {
			reachableSquares(outgoingStreet.to, distance - outgoingStreet.length, reachableSquares);
		}
	}
}
