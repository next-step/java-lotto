package lottery;

import java.util.Objects;

public final class Money {
	private Long amount;

	private Money(Long amount) {
		setAmount(amount);
	}

	public static Money won(Long amount) {
		return new Money(amount);
	}

	public Long amount() {
		return amount;
	}

	private void setAmount(Long amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("유효하지 않는 금액입니다");
		}
		this.amount = amount;
	}

	public Money minus(Money won) {
		return new Money(Math.subtractExact(amount(), won.amount()));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Money))
			return false;
		Money money = (Money)o;
		return Objects.equals(amount, money.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
