package stringaddition;

public class AdditionCalculator {

	public int sum(String formula) {
		StringSplitter splitter = new StringSplitter();
		String[] numbers = splitter.split(formula);
		int solution = 0;
		for (String numberString : numbers) {
			solution += Integer.parseInt(numberString);
		}
		return solution;
	}

}
