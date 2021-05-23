package lotto.domain;

import static lotto.util.ValidationUtils.*;

class Money {

	private static final String INVALID_NUMBER_MESSAGE = "유효하지 않은 숫자입니다.";

	private final int value;

	Money(String money) {
		validate(money);

		value = Integer.parseInt(money.trim());
	}

	private void validate(String money) {
		if (!validateNumber(money)) {
			throw new IllegalArgumentException(Money.INVALID_NUMBER_MESSAGE);
		}
	}

	public int pay(int price) {
		return value / price;
	}

}
