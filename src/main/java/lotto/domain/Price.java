package lotto.domain;

import lotto.utils.ValidationUtils;

public class Price {
	private final int price;

	public Price(int price) {
		ValidationUtils.validatePositive(price);
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
