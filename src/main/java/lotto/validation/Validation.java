package lotto.validation;

import lotto.utils.ErrorMessage;

public class Validation {

	private static final String INT_REG_EXP = "^\\d+$";
	private static final int MONEY_UNIT = 1000;
	public static final int LOTTO_LENGTH = 6;
	public static final int ZERO_POINT = 0;

	private Validation() {
	}

	public static void validThousandUnitCheck(int value) {
		if (value % MONEY_UNIT != ZERO_POINT) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_THOUSAND_UNIT_MESSAGE);
		}
	}

	public static void validEmptyCheck(String lastWinNumber) {
		if (lastWinNumber.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	public static void validNumberTypeCheck(String value) {
		if (!value.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	public static void validLottoSizeCheck(String[] value) {
		if (value.length != LOTTO_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}
}
