package lotto;

import java.util.Objects;

public class Money {
	private final long money;

	public Money(long money) {
		if (money < 0) {
			throw new IllegalArgumentException("금액은 음수가 될 수 없습니다.");
		}
		this.money = money;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}


	public Money multiply(int value) {
		return new Money(money * value);
	}

	public Money plus(Money value) {
		return new Money(money + value.money);
	}

	public boolean isZero() {
		return money == 0;
	}

	public double divide(Money value) {
		return (double)money / value.money;
	}

	public long amount() {
		return money;
	}

	public Money minus(Money value) {
		return new Money(money - value.money);
	}
}
