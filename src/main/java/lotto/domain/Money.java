package lotto.domain;

import lotto.utils.ValidationUtils;

public class Money {
	private final int money;

	public Money(int money) {
		ValidationUtils.validatePositive(money);
		this.money = money;
	}

	public int buyMax(Price price) {
		return money / price.getPrice();
	}
}
