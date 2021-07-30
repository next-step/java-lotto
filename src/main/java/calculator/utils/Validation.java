package calculator.utils;

public class Validation {

	private static final String NUMBER_REG_EXP = "^\\d+$";

	public static void validStringEmptyCheck(String value, String errorMessage) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void validNumberTypeCheck(String value, String errorMessage) {
		if (!value.matches(NUMBER_REG_EXP)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void validPositiveNumber(int value, String errorMessage) {
		if (value < 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
