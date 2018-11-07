package lotto.domain;

import static java.util.Arrays.asList;
import static lotto.enums.Prize.FIRST;
import static lotto.enums.Prize.NO_MATCH;
import static lotto.enums.Prize.SECOND;
import static lotto.enums.Prize.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.enums.Prize;
import org.junit.Test;

public class WinningResultTest {

	@Test
	public void 상금_개수_검증() {
		List<Prize> prizes = asList(THIRD, THIRD, SECOND, FIRST);
		WinningResult winningResult = new WinningResult(prizes);

		assertThat(winningResult.getPrizeCount(THIRD)).isEqualTo(2);
	}

	@Test
	public void 수익률_검증() {
		// 구매한 10개의 복권 중 1개만 당첨(4개 일치)
		Prize prize = THIRD;
		List<Prize> prizes = asList(
				prize, NO_MATCH, NO_MATCH, NO_MATCH, NO_MATCH,
				NO_MATCH, NO_MATCH, NO_MATCH, NO_MATCH, NO_MATCH);
		WinningResult winningResult = new WinningResult(prizes);

		double profitRate = winningResult.calculateProfitRate(prize.getMoney());
		assertThat(profitRate).isEqualTo(1);
	}
}