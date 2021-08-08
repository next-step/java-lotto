package domain;

public class Calculator {

	private static final int INIT_SUM = 0;

	public Integer calculate(final String input) {
		if ("".equals(input) || input == null) {
			return INIT_SUM;
		}
		String[] numbers = input.split(",|:");
		return getResult(numbers);
	}

	private Integer getResult(final String[] numbers) {
		int sum = INIT_SUM;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
