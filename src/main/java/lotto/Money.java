package lotto;

public class Money {

	public static final int LOTTO_PRICE = 1000;

	private final int value;

	public Money(int value) {
		validateMoneyValue(value);

		this.value = value;
	}

	private static void validateMoneyValue(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Money cannot be negative!");
		}
	}

	public int buyCount() {
		return value / LOTTO_PRICE;
	}

	public boolean isEnough() {
		return LOTTO_PRICE <= value;
	}
}
