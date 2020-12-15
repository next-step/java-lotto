package edu.nextstep.lotto.domain;

public class Money {
	private final int money;

	public Money(int money) {
		if (money < 0) {
			throw new IllegalArgumentException("금액은 음수가 될 수 없습니다.");
		}
		this.money = money;
	}

	public int howManyPurchase() {
		return money / Lotto.PRICE;
	}
}