package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoRankTest {

	@Test
	void init6MatchRankTest() {

		LottoRank rank = LottoRank.getRank(6);
		assertThat(rank).isEqualTo(LottoRank.FIRST_RANK);
	}

	@Test
	void init5MatchRankTest() {

		LottoRank rank = LottoRank.getRank(5);
		assertThat(rank).isEqualTo(LottoRank.SECOND_RANK);
	}

	@Test
	void init4MatchRankTest() {

		LottoRank rank = LottoRank.getRank(4);
		assertThat(rank).isEqualTo(LottoRank.NOTHING_RANK);
	}

	@Test
	void init3MatchRankTest() {

		LottoRank rank = LottoRank.getRank(3);
		assertThat(rank).isEqualTo(LottoRank.FOURTH_RANK);
	}

	@Test
	void initNothingRankTest() {

		LottoRank rank = LottoRank.getRank(0);
		assertThat(rank).isEqualTo(LottoRank.NOTHING_RANK);
	}

}
