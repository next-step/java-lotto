package lotto.domain;

import lotto.util.Parser;

public class Amount {
	private final long amount;

	public Amount(long amount) {
		this.amount = amount;
	}

	public Amount(String amount) {
		this.amount = Parser.toLong(amount);
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

	public long divide(Amount lottoPrice) {
		if (this.amount % lottoPrice.amount != 0) {
			throw new IllegalArgumentException(this.amount + "원은 " + lottoPrice.amount + "원의 배수가 아닙니다.");
		}
		return this.amount / lottoPrice.amount;
	}
}
