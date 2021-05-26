package lottery;

import java.util.Objects;

public final class Money {
	public static final Money ZERO = new Money(0L);
	public static final String NOT_VALID_MONEY_EXCEPTION_MESSAGE = "유효하지 않은 로또 금액입니다.";
	private Long amount;

	public static Money won(Long amount) {
		return new Money(amount);
	}

	private Money(Long amount) {
		setAmount(amount);
	}

	public Long amount() {
		return amount;
	}

	private void setAmount(Long amount) {
		if (Objects.isNull(amount) || amount < 0) {
			throw new IllegalArgumentException(NOT_VALID_MONEY_EXCEPTION_MESSAGE);
		}
		this.amount = amount;
	}

	public Money minus(Money won) {
		return new Money(Math.subtractExact(amount, won.amount));
	}

	public long divide(Money won) {
		return Math.floorDiv(this.amount, won.amount);
	}

	public Money multiply(Integer value) {
		return Money.won(Math.multiplyExact(this.amount, value));
	}

	public Money multiply(Long value) {
		return Money.won(Math.multiplyExact(this.amount, value));
	}

	public Money add(Money target) {
		return Money.won(Math.addExact(this.amount, target.amount));
	}

	public float divideWithFloating(Money result) {
		float v = (float)this.amount / result.amount;
		if (Float.isInfinite(v) || Float.isNaN(v)) {
			throw new IllegalArgumentException(NOT_VALID_MONEY_EXCEPTION_MESSAGE);
		}
		return v;
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
