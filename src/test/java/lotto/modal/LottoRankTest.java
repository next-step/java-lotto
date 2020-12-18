package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

	@Test
	@DisplayName("로또 당첨 객체: 1등 당첨 테스트")
	void init6MatchRankTest() {
		LottoRank rank = LottoRank.getRank(6, false);
		assertThat(rank).isEqualTo(LottoRank.FIRST_RANK);
	}

	@Test
	@DisplayName("로또 당첨 객체: 2등 당첨 테스트")
	void init5MatchBonusRankTest() {
		LottoRank rank = LottoRank.getRank(5, true);
		assertThat(rank).isEqualTo(LottoRank.SECOND_RANK);
	}

	@Test
	@DisplayName("로또 당첨 객체: 3등 당첨 테스트")
	void init5MatchRankTest() {
		LottoRank rank = LottoRank.getRank(5, false);
		assertThat(rank).isEqualTo(LottoRank.THIRD_RANK);
	}

	@Test
	@DisplayName("로또 당첨 객체: 4등 당첨 테스트")
	void init4MatchRankTest() {
		LottoRank rank = LottoRank.getRank(4, false);
		assertThat(rank).isEqualTo(LottoRank.FOURTH_RANK);
	}

	@Test
	@DisplayName("로또 당첨 객체: 5등 당첨 테스트")
	void init3MatchRankTest() {
		LottoRank rank = LottoRank.getRank(3, false);
		assertThat(rank).isEqualTo(LottoRank.FIFTH_RANK);
	}

	@Test
	@DisplayName("로또 당첨 객체: 꼴등 당첨 테스트")
	void initNothingRankTest() {
		LottoRank rank = LottoRank.getRank(0, false);
		assertThat(rank).isEqualTo(LottoRank.NOTHING_RANK);
	}

}
