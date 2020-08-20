package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.factory.WinningBallsFactory;

public class WinningComparatorTest {

	@ParameterizedTest
	@MethodSource("winCountProvider")
	public void winCountTest(String winnerNumbers, List<Integer> myNumbers, int except) {
		WinningBalls winningBalls = WinningBallsFactory.create(winnerNumbers);
		LottoNumbers myLottoNumbers = LottoNumbers.of(myNumbers);

		int winCount = winningBalls.getWinningNumbers().getSameCountWith(myLottoNumbers);

		assertThat(winCount).isEqualTo(except);
	}

	@ParameterizedTest
	@MethodSource("rakingProvider")
	public void rankingTest(String winnerNumbers, List<Integer> myNumbers, Ranking except) {
		WinningBalls winningBalls = WinningBallsFactory.create(winnerNumbers);
		LottoNumbers myLottoNumbers = LottoNumbers.of(myNumbers);

		int winCount = winningBalls.getWinningNumbers().getSameCountWith(myLottoNumbers);
		Ranking raking = Ranking.getRakingOf(winCount);

		assertThat(raking).isEqualTo(except);
	}

	private static Stream<Arguments> winCountProvider() {
		return Stream.of(
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(8, 10, 13, 14, 29, 30), 0),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 10, 13, 14, 29, 30), 1),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 13, 14, 29, 30), 2),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 14, 29, 30), 3),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 29, 30), 4),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 5, 30), 5),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 5, 6), 6)
						);
	}

	private static Stream<Arguments> rakingProvider() {
		return Stream.of(
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(8, 10, 13, 14, 29, 30), Ranking.FAILURE),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 10, 13, 14, 29, 30), Ranking.FAILURE),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 13, 14, 29, 30), Ranking.FAILURE),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 14, 29, 30), Ranking.FOURTH),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 29, 30), Ranking.THIRD),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 5, 30), Ranking.SECOND),
				Arguments.arguments("1, 2, 3, 4, 5, 6", Arrays.asList(1, 2, 3, 4, 5, 6), Ranking.FIRST)
						);
	}
}
