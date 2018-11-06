package lotto.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PrizeTest {

	@Test
	public void 상금_검증1() {
		Prize prize = Prize.of(6);

		assertThat(prize).isEqualByComparingTo(Prize.MATCH6);
	}

	@Test
	public void 상금_검증2() {
		Prize prize = Prize.of(3);

		assertThat(prize).isEqualByComparingTo(Prize.MATCH3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 없는_상금_검증() {
		Prize.of(7);
	}
}