package step1.domain;

public class StringAddCalculator {

	public int add(String str) {
		Parser parser = new Parser();
		return parser.parse(str).stream()
				.reduce(0, Integer::sum);
	}

}
