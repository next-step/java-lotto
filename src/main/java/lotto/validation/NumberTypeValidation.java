package lotto.validation;

import lotto.utils.ErrorMessage;

public class NumberTypeValidation {

	private static final String INT_REG_EXP = "^\\d+$";

	private NumberTypeValidation() {
	}

	public static void validNumberTypeCheck(String value) {
		if (!value.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}
}
