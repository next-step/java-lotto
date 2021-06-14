package com.nextstep.lotto.store;

public class LottoStore {
	public static final int LOTTO_PRICE = 1000;
	private final int money;
	private final int manualLottoCount;

	public LottoStore(int money, int manualLottoCount) {
		if (money < LOTTO_PRICE) {
			throw new IllegalArgumentException();
		}

		if (manualLottoCount > (money / LOTTO_PRICE)) {
			throw new IllegalArgumentException();
		}

		this.money = money;
		this.manualLottoCount = manualLottoCount;
	}

	public int autoLottoCount() {
		int remainingAmount = this.money - (manualLottoCount * LOTTO_PRICE);
		return remainingAmount / LOTTO_PRICE;
	}

	public int manualLottoCount() {
		return this.manualLottoCount;
	}

}
