package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGroupTest {

	@Test
	@DisplayName("당첨 통계를 구한다.")
	void test1() {
		List<Integer> lotto1st = Arrays.asList(8, 21, 23, 41, 42, 43);
		List<Integer> lotto2st = Arrays.asList(8, 21, 23, 41, 42, 1);
		List<Integer> lotto3st = Arrays.asList(8, 21, 23, 41, 1, 2);
		List<Integer> lotto4st = Arrays.asList(8, 21, 23, 1, 2, 3);
		List<Integer> failedLotto = Arrays.asList(8, 21, 1, 2, 3, 4);

		LottoGroup lottoGroup = new LottoGroup(Arrays.asList(lotto1st, lotto2st, lotto3st, lotto4st, failedLotto));

		LottoReport report = lottoGroup.lottoResultReport(lotto1st);

		assertThat(report.profit()).isEqualTo(
			(LottoRank.FIRST.reward() + LottoRank.SECOND.reward() + LottoRank.THIRD.reward() + LottoRank.FOURTH.reward()
				+ LottoRank.NOTHING.reward()) / (Lotto.DEFAULT_PRICE * 5));

		assertThat(report.firstPlace()).isEqualTo(1);

		assertThat(report.secondPlace()).isEqualTo(1);

		assertThat(report.thirdPlace()).isEqualTo(1);

		assertThat(report.fourthPlace()).isEqualTo(1);
	}
}
