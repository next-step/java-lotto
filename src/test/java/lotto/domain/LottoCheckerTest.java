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
		assertThat(new LottoChecker(new LottoNumber(1, 2, 3, 4, 5, 6), 14000))
				.isEqualTo(new LottoChecker(new LottoNumber(1, 2, 3, 4, 5, 6), 14000));
	}

	@ParameterizedTest
	@MethodSource("provideWinningResultTestArgs")
	void getWinningResultTest(List<Integer> winningNumbers, List<Integer> drawNumbers, LottoRank exactRank) {
		LottoChecker lottoChecker = new LottoChecker(new LottoNumber(winningNumbers), 1000);

		assertThat(lottoChecker.getWinningResult(new LottoNumber(drawNumbers)))
				.isEqualTo(new LottoResult(Collections.singletonMap(exactRank, 1L), 1000));
	}

	private static Stream<Arguments> provideWinningResultTestArgs(){
		return Stream.of(
				Arguments.of(makeListFromIntegers(1,2,3,4,5,6),makeListFromIntegers(1,2,3,4,5,6),LottoRank.FIRST),
				Arguments.of(makeListFromIntegers(1,2,3,4,5,6),makeListFromIntegers(1,2,3,4,5,7),LottoRank.THIRD),
				Arguments.of(makeListFromIntegers(1,2,3,4,5,6),makeListFromIntegers(1,2,3,4,7,8),LottoRank.FOURTH),
				Arguments.of(makeListFromIntegers(1,2,3,4,5,6),makeListFromIntegers(1,2,3,7,8,9),LottoRank.FIFTH),
				Arguments.of(makeListFromIntegers(1,2,3,4,5,6),makeListFromIntegers(1,2,7,8,9,10),null)
		);
	}

	private static List<Integer> makeListFromIntegers(Integer... ints){
		return Arrays.stream(ints)
				.collect(Collectors.toList());
	}
}