package solutions.aufgabe4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mikeb on 12/9/2019
 */
public class CityBuilder {
	City build() {
		var intersections = new HashMap<String, Intersection>();

		String[] squaresNames = {"Sihlpost", "Bahnhofsplatz", "Loewenplatz", "Central", "Stampfenbachplatz", "Polyterrasse"};
		for (String squareName : squaresNames) {
			intersections.put(squareName, new Square(squareName));
		}

		String[] intersectionNames = {"Bahnhofsplatz-Sihlpost", "Central-Polyterrasse", "Polyterrasse-"};
		for (String intersectionName : intersectionNames) {
			intersections.put(intersectionName, new Intersection());
		}

		intersections.get("Bahnhofsplatz").outgoingStreets.add(new Street(intersections.get("Bahnhofsplatz"), intersections.get("Sihlpost"), 5));
		intersections.get("Bahnhofsplatz").outgoingStreets.add(new Street(intersections.get("Bahnhofsplatz"), intersections.get("Central"), 2));
		intersections.get("Bahnhofsplatz").outgoingStreets.add(new Street(intersections.get("Bahnhofsplatz"), intersections.get("Stampfenbachplatz"), 10));

		intersections.get("Bahnhofsplatz-Sihlpost").outgoingStreets.add(new Street(intersections.get("Bahnhofsplatz-Sihlpost"), intersections.get("Sihlpost"), 6));

		intersections.get("Loewenplatz").outgoingStreets.add(new Street(intersections.get("Loewenplatz"), intersections.get("Bahnhofsplatz"), 6));

		intersections.get("Stampfenbachplatz").outgoingStreets.add(new Street(intersections.get("Stampfenbachplatz"), intersections.get("Bahnhofsplatz"), 10));

		intersections.get("Central").outgoingStreets.add(new Street(intersections.get("Central"), intersections.get("Bahnhofsplatz"), 2));
		intersections.get("Central").outgoingStreets.add(new Street(intersections.get("Central"), intersections.get("Stampfenbachplatz"), 9));
		intersections.get("Central").outgoingStreets.add(new Street(intersections.get("Central"), intersections.get("Central-Polyterrasse"), 7));

		intersections.get("Central-Polyterrasse").outgoingStreets.add(new Street(intersections.get("Central-Polyterrasse"), intersections.get("Central"), 7));
		intersections.get("Central-Polyterrasse").outgoingStreets.add(new Street(intersections.get("Central-Polyterrasse"), intersections.get("Polyterrasse"), 8));

		intersections.get("Polyterrasse").outgoingStreets.add(new Street(intersections.get("Polyterrasse"), intersections.get("Polyterrasse-"), 3));

		return new City(new ArrayList<>(intersections.values()));
	}
}
