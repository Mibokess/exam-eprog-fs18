package solutions.aufgabe4;

/**
 * Created by mikeb on 12/9/2019
 */
public class Street {
	Intersection from;
	Intersection to;

	Integer length;

	public Street(Intersection from, Intersection to, Integer length) {
		this.from = from;
		this.to = to;
		this.length = length;
	}
}
