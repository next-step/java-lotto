package lotto;

import java.util.Objects;

public class Money {
	private final long money;

	public Money(long money) {
		this.money = money;
	}

	public Money(String money) {
		this.money = Long.parseLong(money);
	}

	public long money() {
		return money;
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

	public Money minus(long value) {
		return new Money((money - value));
	}

	public boolean greaterThan(long lottoPrice) {
		return money >= lottoPrice;
	}

	public Money multiply(int value) {
		return new Money(money * value);
	}

	public Money plus(long value) {
		return new Money(money + value);
	}
}
