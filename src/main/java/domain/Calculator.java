package domain;

public class Calculator {

	private static final int INIT_SUM = 0;
	private static final String NUMBER_REGEXP = "^[0-9]+$";

	public Integer calculate(final String input) {
		if ("".equals(input) || input == null) {
			return INIT_SUM;
		}
		if (!input.matches(NUMBER_REGEXP)) {
			throw new RuntimeException("숫자이외의 문자가 들어가있습니다.");
		}
		String[] numbers = input.split(",|:");

		return getResult(numbers);
	}

	private void checkNumbersStatus(final String[] numbers) {
		for(String number : numbers) {
			if (Integer.parseInt(number) < 0) {
				throw new RuntimeException("음수가 들어가있습니다.");
			}
		}
	}

	private Integer getResult(final String[] numbers) {
		int sum = INIT_SUM;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
