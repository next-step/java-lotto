package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

	@Test
	void isEqualTest() {
		assertThat(new LottoChecker(new LottoNumber(1, 2, 3, 4, 5, 6), 14000))
				.isEqualTo(new LottoChecker(new LottoNumber(1, 2, 3, 4, 5, 6), 14000));
	}

	@Test
	void getWinningResultTest() {
		LottoChecker lottoChecker = new LottoChecker(new LottoNumber(1, 2, 3, 4, 5, 6), 1000);

		assertThat(lottoChecker.getWinningResult(new LottoNumber(1, 2, 3, 4, 5, 6)))
				.isEqualTo(new LottoResult(Collections.singletonMap(LottoRank.FIRST, 1L), 1000));

		assertThat(lottoChecker.getWinningResult(new LottoNumber(1, 2, 3, 4, 5, 7)))
				.isEqualTo(new LottoResult(Collections.singletonMap(LottoRank.SECOND, 1L), 1000));

		assertThat(lottoChecker.getWinningResult(new LottoNumber(1, 2, 3, 4, 7, 8)))
				.isEqualTo(new LottoResult(Collections.singletonMap(LottoRank.THIRD, 1L), 1000));

		assertThat(lottoChecker.getWinningResult(new LottoNumber(1, 2, 3, 7, 8, 9)))
				.isEqualTo(new LottoResult(Collections.singletonMap(LottoRank.FOURTH, 1L), 1000));

		assertThat(lottoChecker.getWinningResult(new LottoNumber(1, 2, 7, 8, 9, 10)))
				.isEqualTo(new LottoResult(Collections.EMPTY_MAP, 1000));
	}

}