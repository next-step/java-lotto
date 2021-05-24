package lotto.model;

import java.util.Objects;

public class Money {
	private static final int ZERO = 0;
	static final Money ZERO_WONS = Money.ofWons(ZERO);
	static final Money LOTTO_PRICE = Money.ofWons(1000);

	private final int amount;

	private Money(int amount) {
		validateNonNegative(amount);
		this.amount = amount;
	}

	private void validateNonNegative(int amount) {
		if (amount < ZERO) {
			throw new IllegalArgumentException("음수는 돈이 될 수 없다.");
		}
	}

	public static Money ofWons(int amount) {
		return new Money(amount);
	}

	public int getAmount() {
		return amount;
	}

	public Count countLotto() {
		return Count.of(divided(LOTTO_PRICE));
	}

	Money times(int count) {
		return new Money(this.amount * count);
	}

	Money plus(Money other) {
		return new Money(this.amount + other.amount);
	}

	public double divided(Money other) {
		if (other.equals(ZERO_WONS)) {
			throw new IllegalArgumentException("0 원으로 나눌 수 없습니다.");
		}
		return this.amount / (double) other.amount;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Money otherMoney = (Money) other;
		return amount == otherMoney.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
