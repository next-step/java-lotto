package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

	@Test
	@DisplayName("자신의 상금에 횟수를 곱한 결과를 반환해야 한다.")
	public void multiplyPrizeTest() {
		Money money = LottoRank.FOURTH.multiplyPrize(4);

		assertThat(money).isEqualTo(Money.ofWons(20_000));
	}

}