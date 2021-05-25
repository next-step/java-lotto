package lotto.domain;

import static lotto.util.ValidationUtils.*;

public class Money {

	private static final String INVALID_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";

	private final int value;

	public Money(String money) {
		validate(money);

		value = Integer.parseInt(money.trim());
	}

	private void validate(String money) {
		if (!validateNumber(money)) {
			throw new IllegalArgumentException(Money.INVALID_NUMBER_MESSAGE);
		}
	}

	public int divide(int price) {
		return value / price;
	}

}
