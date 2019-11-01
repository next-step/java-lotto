package lotto.domain.person;

import java.util.Objects;

public class Wallet {

	private long amount;

	private Wallet(long amount) {
		this.amount = amount;
	}

	public static Wallet of(long amount) {
		return new Wallet(amount);
	}

	public boolean hasMoreThan(long comparedAmount) {
		return amount >= comparedAmount;
	}

	public void minus(long minusAmount) {
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
