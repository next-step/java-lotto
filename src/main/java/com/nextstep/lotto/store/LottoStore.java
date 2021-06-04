package com.nextstep.lotto.store;

public class LottoStore {
	public static final int LOTTO_PRICE = 1000;
	private final int money;

	public LottoStore(int money) {
		if (money < LOTTO_PRICE) {
			throw new IllegalArgumentException();
		}
		this.money = money;
	}

	public int lottoCount() {
		return this.money / LOTTO_PRICE;
	}
}
