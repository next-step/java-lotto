package lotto.validation;

import lotto.utils.ErrorMessage;

public class NumberPositiveValidation {

	private NumberPositiveValidation() {
	}

	public static void validPositiveCheck(int money) {
		if (money < 0) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_POSITIVE_MESSAGE);
		}

	}
}
