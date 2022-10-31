package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.MoneyNegativeException;

public class Money {

	private int value;

	public Money(int value) {
		if (isNegative(value)) {
			throw new MoneyNegativeException(ErrorMessage.MONEY_MUST_BE_POSITIVE);
		}
		this.value = value;
	}

	private boolean isNegative(int value) {
		return value < 0;
	}

	public int getValue() {
		return value;
	}
}
