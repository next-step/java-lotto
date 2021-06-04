package com.nextstep.lotto.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoRankTest {
	@Test
	void 일치하는_숫자_6개일때() {
		assertThat(LottoRank.match(6)).isEqualTo(LottoRank.FIRST_RANK);
	}

	@Test
	void 일치하는_숫자_5개일때() {
		assertThat(LottoRank.match(5)).isEqualTo(LottoRank.THIRD_RANK);
	}

	@Test
	void 일치하는_숫자_4개일때() {
		assertThat(LottoRank.match(4)).isEqualTo(LottoRank.FOURTH_RANK);
	}

	@Test
	void 일치하는_숫자_3개일때() {
		assertThat(LottoRank.match(3)).isEqualTo(LottoRank.FIFTH_RANK);
	}

	@Test
	void 일치하는_숫자_2개일때() {
		assertThat(LottoRank.match(2)).isEqualTo(LottoRank.NO_RANK);
	}

	@Test
	void 일치하는_숫자_1개일때() {
		assertThat(LottoRank.match(1)).isEqualTo(LottoRank.NO_RANK);
	}
}
