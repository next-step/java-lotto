package lotto.domain;

import java.util.Objects;

public class Budget {
	public static final int MAXIMUM_LIMIT = 10000000;
	public static final int MINIMUM_LIMIT = 0;

	private final int amount;

	public Budget(String amount) {
		this(Integer.parseInt(amount));
	}

	public Budget(int amount) {
		this.amount = amount;

		if (this.amount < MINIMUM_LIMIT) {
			throw new RuntimeException("budget must be over 0");
		}

		if (this.amount > MAXIMUM_LIMIT) {
			throw new RuntimeException("budget can not exceed over 10 million");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Budget budget = (Budget)o;
		return amount == budget.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
