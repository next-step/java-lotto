package lotto.domain;

import static java.util.Arrays.asList;
import static lotto.enums.Prize.MATCH4;
import static lotto.enums.Prize.MATCH5;
import static lotto.enums.Prize.MATCH6;
import static lotto.enums.Prize.NO_MATCH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.enums.Prize;
import org.junit.Test;

public class WinningResultTest {

	@Test
	public void 상금_개수_검증() {
		List<Prize> prizes = asList(MATCH4, MATCH4, MATCH5, MATCH6);
		WinningResult winningResult = new WinningResult(prizes);

		assertThat(winningResult.getPrizeCount(MATCH4)).isEqualTo(2);
	}

	@Test
	public void 수익률_검증() {
		// 구매한 10개의 복권 중 1개만 당첨(4개 일치)
		Prize prize = MATCH4;
		List<Prize> prizes = asList(
				prize, NO_MATCH, NO_MATCH, NO_MATCH, NO_MATCH,
				NO_MATCH, NO_MATCH, NO_MATCH, NO_MATCH, NO_MATCH);
		WinningResult winningResult = new WinningResult(prizes);

		double profitRate = winningResult.calculateProfitRate(prize.getMoney());
		assertThat(profitRate).isEqualTo(1);
	}
}