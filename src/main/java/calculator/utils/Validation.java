package calculator.utils;

public class Validation {

	private static final String NUMBER_REG_EXP = "^\\d+$";

	public static void validStringEmptyCheck(String value) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	public static void validNumberTypeCheck(String value) {
		if (!value.matches(NUMBER_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	public static void validPositiveNumber(int value) {
		if (value < 0) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_POSITIVE_ERROR_MESSAGE);
		}
	}
}
