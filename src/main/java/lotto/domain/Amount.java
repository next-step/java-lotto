package lotto.domain;

public class Amount {
	private final long amount;

	public Amount(long amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Amount amount1 = (Amount)o;

		return amount == amount1.amount;
	}

	@Override
	public int hashCode() {
		return (int)(amount ^ (amount >>> 32));
	}
}
