package lotto.domain;

import lotto.dto.LottoNumbers;
import lotto.dto.LottoRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningNumberTest {

	@ParameterizedTest
	@MethodSource("provideWinningResultTestArgs")
	void matchWinningTest(LottoNumber winningNumber, LottoNo bonusWinNumber, LottoNumber drawNumbers, LottoRank exactRank) {
		LottoWinningNumber lottoNumber = new LottoWinningNumber(winningNumber, bonusWinNumber);
		assertThat(lottoNumber.matchLottoNumber(drawNumbers))
				.isEqualTo(exactRank);
	}

	private static Stream<Arguments> provideWinningResultTestArgs() {
		return Stream.of(
				Arguments.of(makeLottoNumber(1, 2, 3, 4, 5, 6), LottoNo.getInstance(7), makeLottoNumber(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
				Arguments.of(makeLottoNumber(1, 2, 3, 4, 5, 6), LottoNo.getInstance(7), makeLottoNumber(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
				Arguments.of(makeLottoNumber(1, 2, 3, 4, 5, 6), LottoNo.getInstance(45), makeLottoNumber(1, 2, 3, 4, 5, 7), LottoRank.THIRD),
				Arguments.of(makeLottoNumber(1, 2, 3, 4, 5, 6), LottoNo.getInstance(7), makeLottoNumber(1, 2, 3, 4, 7, 8), LottoRank.FOURTH),
				Arguments.of(makeLottoNumber(1, 2, 3, 4, 5, 6), LottoNo.getInstance(7), makeLottoNumber(1, 2, 3, 7, 8, 9), LottoRank.FIFTH),
				Arguments.of(makeLottoNumber(1, 2, 3, 4, 5, 6), LottoNo.getInstance(7), makeLottoNumber(1, 2, 7, 8, 9, 10), null)
		);
	}

	private static LottoNumber makeLottoNumber(Integer... ints) {
		return new LottoNumber(Arrays.asList(ints));
	}
}