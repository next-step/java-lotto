package lotto.model;

import java.util.Objects;

public class Money {
	private static final int ZERO = 0;
	static final Money ZERO_WONS = Money.wons(ZERO);
	public static final Money LOTTO_PRICE = Money.wons(1000);

	private final int money;

	private Money(int money) {
		validateNonNegative(money);
		this.money = money;
	}

	private void validateNonNegative(int money) {
		if (money < ZERO) {
			throw new IllegalArgumentException("음수는 돈이 될 수 없다.");
		}
	}

	public static Money wons(int input) {
		return new Money(input);
	}

	public int getMoney() {
		return money;
	}

	Money times(int count) {
		return new Money(this.money * count);
	}

	Money plus(Money other) {
		return new Money(this.money + other.money);
	}

	public double divided(Money other) {
		if (other.equals(ZERO_WONS)) {
			throw new IllegalArgumentException("0 원으로 나눌 수 없습니다.");
		}
		return this.money / (double) other.money;
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
		return money == otherMoney.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
