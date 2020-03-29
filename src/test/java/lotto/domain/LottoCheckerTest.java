package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

	@Test
	void isEqualTest() {
		assertThat(new LottoChecker(new LottoWinningNumber(7, 1, 2, 3, 4, 5, 6), 14000))
				.isEqualTo(new LottoChecker(new LottoWinningNumber(7, 1, 2, 3, 4, 5, 6), 14000));
	}

	@Test
	void getWinningResultTest() {
		LottoChecker lottoChecker = new LottoChecker(new LottoWinningNumber(7,1,2,3,4,5,6), 1000);

		assertThat(
				lottoChecker.getWinningResult(
						new LottoNumber(1,2,3,4,5,6),
						new LottoNumber(1,2,3,4,5,6)))
				.isEqualTo(new LottoResult(Collections.singletonMap(LottoRank.FIRST, 2L), 1000));
	}
}