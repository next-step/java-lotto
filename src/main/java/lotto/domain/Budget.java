package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Budget {
	public static final int MAXIMUM_LIMIT = 10000000;
	public static final int MINIMUM_LIMIT = 0;

	private final int amount;

	public Budget(int amount) {
		this.amount = amount;

		validateAmountRange();
		validateBuyable(amount);
	}

	private void validateAmountRange() {
		if (amount < MINIMUM_LIMIT || amount > MAXIMUM_LIMIT) {
			throw new RuntimeException("budget must be within range(0 - 10000000)");
		}
	}

	private void validateBuyable(int amount) {
		if (amount < Lotto.LOTTO_PRICE) {
			throw new RuntimeException("you can not buy even one lotto");
		}
	}

	public int getPossibleCount(List<Lotto> lottos) {
		return getRemainBudget(lottos.size()) / Lotto.LOTTO_PRICE;
	}

	private int getRemainBudget(int size) {
		int remain = amount - (size * Lotto.LOTTO_PRICE);
		validateRemainAmount(remain);

		return remain;
	}

	private void validateRemainAmount(int remain) {
		if (remain < 0) {
			throw new RuntimeException("you can not but more lottos");
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
