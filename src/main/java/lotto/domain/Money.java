package lotto.domain;

public final class Money {

	private final Integer value;

	public Money(Integer value) {
		this.value = validateMoneyRange(value);
	}

	private int validateMoneyRange(Integer money) {
		if (money == 0) {
			return money;
		}
		if (money < 1000) {
			throw new RuntimeException("money input is wrong.");
		}
		return money;
	}

	public int getNumberOfPurchasedLotto() {
		final double TICKET_PRICE = 1000;
		return (int) (value / TICKET_PRICE);
	}

	public Integer getValue() {
		return value;
	}
}
