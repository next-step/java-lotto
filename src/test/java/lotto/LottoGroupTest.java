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
		Lotto lotto1st = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43), 9, lottoPrice);
		Lotto lotto2st = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 1), 10, lottoPrice);
		Lotto lotto3st = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 1), 9, lottoPrice);
		Lotto lotto4st = new Lotto(Arrays.asList(8, 21, 23, 41, 1, 2), 9, lottoPrice);
		Lotto lotto5st = new Lotto(Arrays.asList(8, 21, 23, 1, 2, 3), 9, lottoPrice);
		Lotto failedLotto = new Lotto(Arrays.asList(8, 21, 1, 2, 3, 4), 9, lottoPrice);

		Lotto winningNumbers = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43), 10, lottoPrice);

		LottoGroup lottoGroup = new LottoGroup(
			Arrays.asList(lotto1st, lotto2st, lotto3st, lotto4st, lotto5st, failedLotto));

		LottoPaper report = lottoGroup.lottoResultReport(winningNumbers);

		double totalProfit =
			LottoRank.FIRST.reward() + LottoRank.SECOND.reward() + LottoRank.THIRD.reward() + LottoRank.FOURTH.reward()
				+ LottoRank.FIFTH.reward()
				+ LottoRank.NOTHING.reward();
		double paidMoney = lottoPrice * 6;

		assertThat(report.profit()).isEqualTo(totalProfit / paidMoney);

		assertThat(report.lottoMatchCount(6, false)).isEqualTo(1);

		assertThat(report.lottoMatchCount(5, true)).isEqualTo(1);

		assertThat(report.lottoMatchCount(5, false)).isEqualTo(1);

		assertThat(report.lottoMatchCount(4, false)).isEqualTo(1);

		assertThat(report.lottoMatchCount(3, false)).isEqualTo(1);
	}
}
