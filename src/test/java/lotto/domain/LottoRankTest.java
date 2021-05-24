package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

	@DisplayName("로또 번호 비교 결과가 6개 맞을 때 1등으로 판단하는지 테스트")
	@Test
	void isFirst() {
		// given
		int matchCount = 6;

		// when
		LottoRank lottoRank = LottoRank.rank(matchCount);

		// then
		assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
	}

	@DisplayName("로또 번호 비교 결과가 5개 맞을 때 2등으로 판단하는지 테스트")
	@Test
	void isSecond() {
		// given
		int matchCount = 5;

		// when
		LottoRank lottoRank = LottoRank.rank(matchCount);

		// then
		assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
	}

	@DisplayName("Rank 에 정의한 숫자를 전달했을 때, 순위권 밖으로 판단하는지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, 2, 7})
	void isOutOfRank(int matchCount) {
		// when
		LottoRank lottoRank = LottoRank.rank(matchCount);

		// then
		assertThat(lottoRank).isEqualTo(LottoRank.OUT_OF_RANK);
	}

}
