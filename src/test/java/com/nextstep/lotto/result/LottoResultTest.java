package com.nextstep.lotto.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoResultTest {
	@Test
	void create() {
		LottoResult lottoResult = new LottoResult();
		assertThat(lottoResult).isNotNull();
	}

	@Test
	void 통계() {
		LottoResult lottoResult = new LottoResult();
		lottoResult.addResult(LottoRank.FIFTH_RANK);
		assertThat(lottoResult.revenueRatio(5000)).isEqualTo(1.0);
	}
}
