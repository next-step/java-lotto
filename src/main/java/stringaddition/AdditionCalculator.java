package stringaddition;

public class AdditionCalculator {

	public int sum(String formula) {
		String[] numbers = new StringSplitter().split(formula);
		return sum(numbers);
	}

	private int sum(String[] numbers) {
		int solution = 0;
		for (String number : numbers) {
			solution += Integer.parseInt(number);
		}
		return solution;
	}

}
