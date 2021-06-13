package com.nextstep.lotto.result;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class LottoResultTest {
	@Test
	void create() {
		LottoResult lottoResult = new LottoResult();
		assertThat(lottoResult).isNotNull();
	}

	@Test
	void 수익률() {
		LottoResult lottoResult = new LottoResult();
		lottoResult.addResult(LottoRank.FIFTH_RANK);
		assertThat(lottoResult.revenueRatio(5000)).isEqualTo(1.0);
	}

	@Test
	void 로또_결과_당첨통계() {
		LottoResult lottoResult = new LottoResult();
		lottoResult.addResult(LottoRank.FIRST_RANK);
		lottoResult.addResult(LottoRank.SECOND_RANK);
		lottoResult.addResult(LottoRank.SECOND_RANK);

		Map<LottoRank, Long> resultMap = lottoResult.statistics();
		assertThat(resultMap.get(LottoRank.FIRST_RANK)).isEqualTo(1);
		assertThat(resultMap.get(LottoRank.SECOND_RANK)).isEqualTo(2);
	}
}
