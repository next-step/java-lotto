package step2.domain.var;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {
	@Test
	@DisplayName("보너스볼 + 당첨된 번호가 5개일때 2등 상금을 받는 테스트")
	void secondWinnerTest() {
		assertThat(LottoPrize.valueOf(LottoPrize.SECOND.getCount(), true).getPrize())
			.isEqualTo(LottoPrize.SECOND.getPrize());
	}

	@Test
	@DisplayName("보너스볼 X + 당첨된 번호가 5개일때 3등 상금을 받는 테스트")
	void thirdWinnerTest() {
		assertThat(LottoPrize.valueOf(LottoPrize.THIRD.getCount(), false).getPrize())
			.isEqualTo(LottoPrize.THIRD.getPrize());
	}
}