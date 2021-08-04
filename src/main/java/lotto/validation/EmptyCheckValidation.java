package lotto.validation;

import lotto.utils.ErrorMessage;

public class EmptyCheckValidation {

	private EmptyCheckValidation() {
	}

	public static void validEmptyCheck(String lastWinNumber) {
		if (lastWinNumber.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}
}
