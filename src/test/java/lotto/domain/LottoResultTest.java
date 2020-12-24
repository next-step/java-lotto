package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
	private final LottoRank lottoRank = LottoRank.THIRD_PLACE;
	private final int winCount = 2;
	private final LottoResult lottoResult = new LottoResult(lottoRank, winCount);

	@Test
	@DisplayName("같은 등급인지 확인한다.")
	void isEqualRank_test() {
		assertThat(lottoResult.isEqualRank(lottoRank)).isTrue();
		assertThat(lottoResult.isEqualRank(LottoRank.FIRST_PLACE)).isFalse();
	}
}
