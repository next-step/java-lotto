package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

	private static final int PROFIT_RATE_DECIMAL_POINRT = 2;

	private int money;

	public Money(int money) {
		this.money = money;
	}

	public int getPickCount() {
		return money / LottoMachine.LOTTO_PRICE;
	}

	public double calculateProfitRate(int totalPrizeMoney) {
		double profitRate = (double) totalPrizeMoney / money;
		return new BigDecimal(profitRate)
				.setScale(PROFIT_RATE_DECIMAL_POINRT, RoundingMode.HALF_UP)
				.doubleValue();
	}
}
