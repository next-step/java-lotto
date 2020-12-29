package lotto.domain;

import lotto.utils.ValidationUtils;

public class Money {
	private final int money;

	public Money(int money) {
		ValidationUtils.validatePositive(money);
		this.money = money;
	}

	public int buyMax(int price) {
		validateMoney(price);
		return money / price;
	}

	private void validateMoney(int price) {
		if (money < price) {
			throw new IllegalArgumentException(String.format(Message.INVALID_BUY_LOTTO, price));
		}
	}
}
