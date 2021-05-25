package lotto.domain;

import static lotto.domain.LottoRank.*;
import static lotto.domain.LottoStore.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoReportTest {

	private final List<LottoRank> lottoRankList = Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH, OUT_OF_RANK);

	@Test
	void lottoRankMessage() {
		// given
		LottoReport lottoRepost = new LottoReport(lottoRankList);
		String expected = buildRankMessage();

		// when
		String message = lottoRepost.lottoRankMessage();

		// then
		assertThat(message).isEqualTo(expected);
	}

	private String buildRankMessage() {
		return "3개 일치 (5000원)- 1개" + "\r\n"
			+ "4개 일치 (50000원)- 1개" + "\r\n"
			+ "5개 일치 (1500000원)- 1개" + "\r\n"
			+ "5개 일치, 보너스 볼 일치 (30000000원)- 1개" + "\r\n"
			+ "6개 일치 (2000000000원)- 1개" + "\r\n";
	}

	@Test
	void earningRatio() {
		// given
		LottoReport lottoRepost = new LottoReport(lottoRankList);
		BigDecimal bigDecimal = new BigDecimal(FIRST.money() + SECOND.money() + THIRD.money() + FOURTH.money());
		BigDecimal expect = bigDecimal.divide(BigDecimal.valueOf((long)lottoRankList.size() * PRICE), 2,
			BigDecimal.ROUND_DOWN);

		// when
		BigDecimal ratio = lottoRepost.earningRatio();

		// then
		assertThat(ratio).isEqualTo(expect);
	}

}
