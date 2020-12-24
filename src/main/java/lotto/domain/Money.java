package lotto.domain;

import lotto.utils.ValidationUtils;

public class Money {
	private final int money;

	public Money(int money) {
		ValidationUtils.validatePositive(money);
		this.money = money;
	}

	public int buyMax(int price) {
		return money / price;
	}
}
