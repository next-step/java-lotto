package lotto.domain;

import java.util.Objects;

public class LottoMoney {
	private static final int PRIZE = 1000;

	private final long money;

	public LottoMoney(long money) {
		if (money < 0) {
			throw new IllegalArgumentException("money must be positive number");
		}

		this.money = money;
	}

	int getLottoNumbersCount() {
		if (money == 0) {
			return 0;
		}
		return (int) (money / PRIZE);
	}

	public long getSpentMoney() {
		return money;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoMoney that = (LottoMoney) o;
		return money == that.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
