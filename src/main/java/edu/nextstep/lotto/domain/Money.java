package edu.nextstep.lotto.domain;

import edu.nextstep.lotto.domain.sub.Lotto;

public class Money {
	private int money;

	public Money(int money) {
		if (money < 0) {
			throw new IllegalArgumentException("금액은 음수가 될 수 없습니다.");
		}
		this.money = money;
	}

	public int howManyPurchase() {
		return money / Lotto.PRICE;
	}

	public void minusByNumberOfLotto(int number) {
		if(hasNotEnoughToPurchase(number)){
			throw new IllegalArgumentException("현재 금액이 " + number + "개의 로또를 구매할 만큼 충분하지 않습니다.");
		}
		money -= number * Lotto.PRICE;
	}

	private boolean hasNotEnoughToPurchase(int number) {
		return number * Lotto.PRICE > money;
	}
}