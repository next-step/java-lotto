package lotto;

public class Money {

	private static final int LOTTO_PRICE = 1000;

	private final int value;

	public Money(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Money cannot be negative!");
		}

		this.value = value;
	}

	public boolean isEnough() {
		return LOTTO_PRICE <= value;
	}

	public int buyCount() {
		return value / LOTTO_PRICE;
	}
}
