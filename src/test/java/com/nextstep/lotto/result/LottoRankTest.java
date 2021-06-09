package com.nextstep.lotto.result;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoRankTest {
	@Test
	void 일치하는_숫자_6개일때() {
		assertThat(LottoRank.valueOf(6, true)).isEqualTo(LottoRank.FIRST_RANK);
		assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST_RANK);
	}

	@Test
	void 일치하는_숫자_5개일때() {
		assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND_RANK);
		assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD_RANK);
	}

	@Test
	void 일치하는_숫자_4개일때() {
		assertThat(LottoRank.valueOf(4, true)).isEqualTo(LottoRank.FOURTH_RANK);
		assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH_RANK);
	}

	@Test
	void 일치하는_숫자_3개일때() {
		assertThat(LottoRank.valueOf(3, true)).isEqualTo(LottoRank.FIFTH_RANK);
		assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH_RANK);
	}

	@Test
	void 일치하는_숫자_2개일때() {
		assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NO_RANK);
		assertThat(LottoRank.valueOf(2, true)).isEqualTo(LottoRank.NO_RANK);
	}

	@Test
	void 일치하는_숫자_1개일때() {
		assertThat(LottoRank.valueOf(1, true)).isEqualTo(LottoRank.NO_RANK);
		assertThat(LottoRank.valueOf(1, false)).isEqualTo(LottoRank.NO_RANK);
	}
}
