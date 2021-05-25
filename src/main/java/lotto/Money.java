package lotto;

import static lotto.LottoUtils.*;

public class Money {

	private final int value;

	public Money(int value) {
		validateMoneyValue(value);

		this.value = value;
	}

	public int buyCount() {
		return value / LOTTO_PRICE;
	}

	public boolean isEnough() {
		return LOTTO_PRICE <= value;
	}

	private void validateMoneyValue(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Money cannot be negative!");
		}
	}
}
