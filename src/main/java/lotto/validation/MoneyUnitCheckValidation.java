package lotto.validation;

import lotto.utils.ErrorMessage;

public class MoneyUnitCheckValidation {

	private static final int MONEY_UNIT = 1000;
	public static final int ZERO_POINT = 0;

	private MoneyUnitCheckValidation() {
	}

	public static void validThousandUnitCheck(int value) {
		if (value % MONEY_UNIT != ZERO_POINT) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_THOUSAND_UNIT_MESSAGE);
		}
	}
}
