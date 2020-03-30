package lotto.domain;

import lotto.domain.dto.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

	@Test
	void isEqualTest() {
		assertThat(new LottoNumber(1, 2, 3, 4, 5, 6))
				.isEqualTo(new LottoNumber(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("객체 생성 유효성 테스트")
	void expectConstructorException() {
		assertThatThrownBy(() -> new LottoNumber(1))
				.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> new LottoNumber(1, 2, 3, 4, 5, 5))
				.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@MethodSource("provideWinningResultTestArgs")
	void matchWinningTest(List<Integer> winningNumbers, int bonusWinNumber, List<Integer> drawNumbers, LottoRank exactRank) {
		LottoNumber lottoNumber = new LottoNumber(drawNumbers);
		assertThat(lottoNumber.matchLottoNumber(new LottoWinningNumber(winningNumbers, bonusWinNumber)))
				.isEqualTo(exactRank);
	}

	private static Stream<Arguments> provideWinningResultTestArgs() {
		return Stream.of(
				Arguments.of(makeListFromIntegers(1, 2, 3, 4, 5, 6), 7, makeListFromIntegers(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
				Arguments.of(makeListFromIntegers(1, 2, 3, 4, 5, 6), 7, makeListFromIntegers(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
				Arguments.of(makeListFromIntegers(1, 2, 3, 4, 5, 6), 45, makeListFromIntegers(1, 2, 3, 4, 5, 7), LottoRank.THIRD),
				Arguments.of(makeListFromIntegers(1, 2, 3, 4, 5, 6), 7, makeListFromIntegers(1, 2, 3, 4, 7, 8), LottoRank.FOURTH),
				Arguments.of(makeListFromIntegers(1, 2, 3, 4, 5, 6), 7, makeListFromIntegers(1, 2, 3, 7, 8, 9), LottoRank.FIFTH),
				Arguments.of(makeListFromIntegers(1, 2, 3, 4, 5, 6), 7, makeListFromIntegers(1, 2, 7, 8, 9, 10), null)
		);
	}

	private static List<Integer> makeListFromIntegers(Integer... ints) {
		return Arrays.stream(ints)
				.collect(Collectors.toList());
	}

}