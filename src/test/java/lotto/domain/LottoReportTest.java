package lotto.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoMachine.*;
import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.*;

class LottoReportTest {

	private final List<LottoRank> lottoRankList = Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, OUT_OF_RANK);

	@Test
	void earningRatio() {
		// given
		LottoReport lottoRepost = new LottoReport(lottoRankList);
		BigDecimal bigDecimal = new BigDecimal(FIRST.money() + SECOND.money() + THIRD.money() + FOURTH.money() + FIFTH.money() + OUT_OF_RANK.money());
		BigDecimal expect = bigDecimal.divide(BigDecimal.valueOf((long)lottoRankList.size() * PRICE), 2,
			BigDecimal.ROUND_DOWN);

		// when
		BigDecimal ratio = lottoRepost.earningRatio();

		// then
		assertThat(ratio).isEqualTo(expect);
	}

}
