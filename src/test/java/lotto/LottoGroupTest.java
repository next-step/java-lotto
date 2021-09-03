package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGroupTest {

	@Test
	@DisplayName("당첨 통계를 구한다.")
	void test1() {
		int lottoPrice = 1000;
		Lotto lotto1st = new Lotto(() -> Arrays.asList(8, 21, 23, 41, 42, 43), lottoPrice);
		Lotto lotto2st = new Lotto(() -> Arrays.asList(8, 21, 23, 41, 42, 1), lottoPrice);
		Lotto lotto3st = new Lotto(() -> Arrays.asList(8, 21, 23, 41, 1, 2), lottoPrice);
		Lotto lotto4st = new Lotto(() -> Arrays.asList(8, 21, 23, 1, 2, 3), lottoPrice);
		Lotto failedLotto = new Lotto(() -> Arrays.asList(8, 21, 1, 2, 3, 4), lottoPrice);

		LottoGroup lottoGroup = new LottoGroup(Arrays.asList(lotto1st, lotto2st, lotto3st, lotto4st, failedLotto));

		LottoPaper report = lottoGroup.lottoResultReport(lotto1st);

		int totalProfit =
			LottoRank.FIRST.reward() + LottoRank.SECOND.reward() + LottoRank.THIRD.reward() + LottoRank.FOURTH.reward()
				+ LottoRank.NOTHING.reward();
		int paidMoney = lottoPrice * 5;

		assertThat(report.profit()).isEqualTo(totalProfit / paidMoney);

		assertThat(report.lottoMatchCount(6)).isEqualTo(1);

		assertThat(report.lottoMatchCount(5)).isEqualTo(1);

		assertThat(report.lottoMatchCount(4)).isEqualTo(1);

		assertThat(report.lottoMatchCount(3)).isEqualTo(1);
	}
}
