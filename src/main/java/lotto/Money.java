package lotto;

import java.util.Objects;

public class Money implements Comparable<Money> {
	private double money;

	public Money(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("돈은 0보다 작을 수 없습니다.");
		}
		this.money = money;
	}

	public void spend(Money price) {
		if (compareTo(price) >= 0 && this.money >= 0) {
			this.money -= price.money;
			return;
		}
		throw new IllegalArgumentException("지불할 수 없습니다.");
	}

	public Money add(Money price) {
		return new Money(this.money + price.money);
	}

	public Money divide(Money lottoPrice) {
		return new Money(this.money / lottoPrice.money);
	}

	public double money() {
		return this.money;
	}

	public boolean biggerThan(Money lottoPrice) {
		return this.compareTo(lottoPrice) >= 0;
	}

	@Override
	public int compareTo(Money other) {
		return Double.compare(this.money, other.money);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return Double.compare(money1.money, money) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
