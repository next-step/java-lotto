package lotto.modal;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

	private static final int LOTTO_PRICE_MONEY = 1000;

	private final int inputMoney;

	private Money(int money) {
		this.inputMoney = money;
	}

	public static Money generateMoney(int money) {
		validateMoney(money);
		return new Money(money);
	}

	public int getBuyCount() {
		return inputMoney / LOTTO_PRICE_MONEY;
	}

	public BigDecimal getYield(long totalPrize) {
		BigDecimal money = new BigDecimal(this.inputMoney);
		return new BigDecimal(totalPrize).divide(money, 2, BigDecimal.ROUND_HALF_UP);
	}

	private static void validateMoney(int money) {
		if (money < LOTTO_PRICE_MONEY) {
			throw new IllegalArgumentException("로또 구매 최소 금액은 " + LOTTO_PRICE_MONEY + "원 입니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return this.inputMoney == money.inputMoney;
	}

	@Override
	public int hashCode() {
		return Objects.hash(inputMoney);
	}
}
