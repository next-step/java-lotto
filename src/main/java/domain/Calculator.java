package domain;

public class Calculator {

	private static final int INIT_SUM = 0;
	private static final String NUMBER_REGEXP = "^[0-9]+$";

	public Integer calculate(final String input) {
		if ("".equals(input) || input == null) {
			return INIT_SUM;
		}

		String[] numbers = input.split(",|:");
		otherCharacterStatus(numbers);
		numbersMinusStatus(numbers);

		return getResult(numbers);
	}

	private void numbersMinusStatus(final String[] numbers) {
		for (String number : numbers) {
			checkNumberMinusStatus(number);
		}
	}

	private void checkNumberMinusStatus(final String number) {
		if (Integer.parseInt(number) < 0) {
			throw new RuntimeException("음수가 들어가있거나 숫자이외의 문자가 있습니다.");
		}
	}

	private void otherCharacterStatus(final String[] numbers) {
		for (String number : numbers) {
			checkOtherCharacterStatus(number);
		}
	}

	private void checkOtherCharacterStatus(final String number) {
		if (!number.matches(NUMBER_REGEXP)) {
			throw new RuntimeException("음수가 들어가있거나 숫자이외의 문자가 있습니다.");
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
