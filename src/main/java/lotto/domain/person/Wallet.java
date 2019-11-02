package lotto.domain.person;

import java.util.Objects;

public class Wallet {

	private static final long MIN_AMOUNT = 0;

	private long amount;

	private Wallet(long amount) {
		validateAmount(amount);
		this.amount = amount;
	}

	private void validateAmount(long amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(String.format("금액(%s)은 %s원 미만일 수 없습니다",amount, MIN_AMOUNT));
		}
	}

	public static Wallet of(long amount) {
		return new Wallet(amount);
	}

	public boolean hasMoreThan(long comparedAmount) {
		return amount >= comparedAmount;
	}

	public void minus(long minusAmount) {
		validateAmount(amount - minusAmount);
		this.amount -= minusAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Wallet wallet = (Wallet) o;
		return amount == wallet.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

}
