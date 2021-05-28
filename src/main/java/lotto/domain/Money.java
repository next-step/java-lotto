package lotto.domain;

import static lotto.domain.LottoMachine.*;
import static lotto.util.ValidationUtils.*;

public class Money {

	private static final String INVALID_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";
	public static final String NOT_ENOUGH_MONEY_MESSAGE = String.format("로또는 한 장에 %s 원입니다.", PRICE);

	private final int value;

	public Money(String money) {
		validate(money);

		value = Integer.parseInt(money);
	}

	private void validate(String moneyString) {
		if (!validateNumber(moneyString)) {
			throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
		}

		int money = Integer.parseInt(moneyString);

		if (money / PRICE <= 0) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY_MESSAGE);
		}
	}

	public int divide(int price) {
		return value / price;
	}

	public boolean isEnough(int count) {
		return value >= count * PRICE;
	}
}
