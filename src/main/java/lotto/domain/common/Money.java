package lotto.domain.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Created by hspark on 10/11/2018.
 */
public final class Money implements Comparable<Money> {

	private static final Cache<Long, Money> CACHE = new HashMapCache<>();

	private final BigDecimal amount;

	public static final Money ZERO = new Money(BigDecimal.ZERO);

	private Money(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException();
		}
		this.amount = amount;
	}

	public static Money of(int amount) {
		return of((long) amount);
	}

	public static Money of(long amount) {
		Money cacheMoney = CACHE.get(amount);
		if (Objects.nonNull(cacheMoney)) {
			return cacheMoney;
		}
		cacheMoney = new Money(BigDecimal.valueOf(amount));
		CACHE.put(amount, cacheMoney);
		return cacheMoney;
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

	public Money remainder(Money target) {
		return new Money(getAmount().remainder(target.amount));
	}

	public Money multiply(Money target) {
		return new Money(getAmount().multiply(target.getAmount()));
	}

	public Money multiply(long target) {
		return new Money(getAmount().multiply(BigDecimal.valueOf(target)));
	}

	public Money multiply(int target) {
		return new Money(getAmount().multiply(BigDecimal.valueOf(target)));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Money money = (Money) o;

		return amount != null ? amount.equals(money.amount) : money.amount == null;
	}

	@Override
	public int hashCode() {
		return amount != null ? amount.hashCode() : 0;
	}

	@Override
	public int compareTo(Money o) {
		return getAmount().compareTo(o.amount);
	}

	public Money divide(Money target) {
		return new Money(getAmount().divide(target.getAmount(), RoundingMode.DOWN));
	}

	public BigDecimal divideValue(Money target) {
		return divide(target).getAmount();
	}

	public static BigDecimal calculateRate(Money money, Money anotherMoney) {
		BigDecimal profitRate = money.getAmount().divide(anotherMoney.amount, 2, RoundingMode.DOWN);
		return profitRate.setScale(2, BigDecimal.ROUND_DOWN);
	}

	@Override
	public String toString() {
		return "" + amount;
	}
}