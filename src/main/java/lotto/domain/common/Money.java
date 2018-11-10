package lotto.domain.common;

import java.math.BigDecimal;

/**
 * Created by hspark on 10/11/2018.
 */
public final class Money {
	private final BigDecimal amount;

	private Money(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException();
		}
		this.amount = amount;
	}

	public static Money of(int amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Money add(Money target) {
		return new Money(getAmount().add(target.getAmount()));
	}

	public Money subtract(Money target) {
		return new Money(getAmount().subtract(target.amount));
	}
}