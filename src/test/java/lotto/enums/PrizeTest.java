package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PrizeTest {

	@Test
	public void 상금_검증1() {
		Prize prize = Prize.of(6, false);

		assertThat(prize).isEqualTo(Prize.FIRST);
	}

	@Test
	public void 상금_검증2() {
		Prize prize = Prize.of(3, false);

		assertThat(prize).isEqualTo(Prize.FIFTH);
	}

	@Test
	public void 없는_상금_검증() {
		Prize prize = Prize.of(7, false);
		assertThat(prize).isEqualTo(Prize.NO_MATCH);
	}

	@Test
	public void 당첨금_합계_검증() {
		int totalMoney = 50000;
		assertThat(Prize.THIRD.sumMoney(totalMoney))
				.isEqualTo(totalMoney + Prize.THIRD.getMoney());
	}
}