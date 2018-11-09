package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void 수익률_검증() {
		final int totalPrizeMoney = 20000;
		Money money = new Money(10000);
		double profitRate = money.calculateProfitRate(totalPrizeMoney);
		assertThat(profitRate).isEqualTo(2.0);
	}

	@Test
	public void 수익률_검증2() {
		final int totalPrizeMoney = 5000;
		Money money = new Money(14000);
		double profitRate = money.calculateProfitRate(totalPrizeMoney);
		assertThat(profitRate).isEqualTo(0.36);
	}
}