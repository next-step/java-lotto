package com.nextstep.lotto.store;

public class LottoStore {

	private static final int LOTTO_PRICE = 1000;
	private static final String PRICE_IS_AT_LEAST_THOUSAND = "금액을 덜 내셨습니다. 하나의 가격은 1,000원입니다.";
	private int money;

	public LottoStore(int money) {
		if (money < LOTTO_PRICE) {
			throw new IllegalArgumentException(PRICE_IS_AT_LEAST_THOUSAND);
		}
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	public int lottoCount() {
		return this.money / LOTTO_PRICE;
	}
}
