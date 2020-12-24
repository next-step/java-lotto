package lotto.domain;

import java.util.Objects;

public class Money {
	private static final int MIN_MONEY_AMOUNT = 0;

	private final int moneyAmount;

	private Money(int moneyAmount) {
		validate(moneyAmount);
		this.moneyAmount = moneyAmount;
	}

	public static Money of(int moneyAmount) {
		return new Money(moneyAmount);
	}

	private void validate(int moneyAmount) {
		if (moneyAmount < MIN_MONEY_AMOUNT) {
			throw new IllegalArgumentException("금액은 0 이상이어야 합니다.");
		}
	}

	public int count(int moneyAmount) {
		if (isNegativeOrZero(moneyAmount)) {
			return 0;
		}
		return this.moneyAmount / moneyAmount;
	}

	public double divide(Money money) {
		if (isNegativeOrZero(money.moneyAmount)) {
			return 0;
		}
		return moneyAmount / (double) money.moneyAmount;
	}

	private boolean isNegativeOrZero(int moneyAmount) {
		return moneyAmount <= MIN_MONEY_AMOUNT;
	}

	public int sum(int moneyAmount) {
		return this.moneyAmount + moneyAmount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Money money = (Money)obj;
		return moneyAmount == money.moneyAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(moneyAmount);
	}
}
