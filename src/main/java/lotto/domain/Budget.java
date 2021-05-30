package lotto.domain;

import java.util.Objects;

public class Budget {
	private final int amount;

	public Budget(String amount) {
		this(Integer.parseInt(amount));
	}

	public Budget(int amount) {
		this.amount = amount;
		if (this.amount < 0) {
			throw new RuntimeException("budget must be over 0");
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
