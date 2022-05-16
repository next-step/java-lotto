package lotto.domain;

import lotto.util.Parser;

public class Amount {
	private final long amount;

	public Amount(long amount) {
		this.amount = amount;
	}

	public Amount(String amount) {
		this(Parser.toLong(amount));
	}


	public long divide(Amount lottoPrice) {
		validateZero(lottoPrice);
		validateRemainder(lottoPrice);

		return this.amount / lottoPrice.amount;
	}

	public long value() {
		return amount;
	}

	public long multi(long count) {
		return this.amount * count;
	}

	private void validateZero(Amount lottoPrice) {
		if (lottoPrice.amount == 0 || this.amount == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}
	}

	private void validateRemainder(Amount lottoPrice) {
		if (this.amount % lottoPrice.amount != 0) {
			throw new IllegalArgumentException(this.amount + "원은 " + lottoPrice.amount + "원의 배수가 아닙니다.");
		}
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

	@Override
	public String toString() {
		return String.valueOf(amount);
	}
}
