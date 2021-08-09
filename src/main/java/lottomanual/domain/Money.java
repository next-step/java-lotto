package lottomanual.domain;

import java.util.Objects;

public class Money {

	private static final int AMOUNT_UNIT = 1_000;

	private final int money;

	private Money(int money) {
		if (money < AMOUNT_UNIT) {
			throw new MoneySizeException();
		}
		this.money = money;
	}

	public static Money of(int money) {
		return new Money(money);
	}

	public static Money of(String money) {
		return new Money(Integer.parseInt(money.trim()));
	}



	public int getLottoCount() {
		return money / AMOUNT_UNIT;
	}

	public Money excludeLottoCount(int count) {
		if (count > getLottoCount()) {
			throw new LottoManualCountException();
		}
		return new Money(money - (count * AMOUNT_UNIT));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money money1 = (Money) o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}


}
