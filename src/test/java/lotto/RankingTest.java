package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.factory.WinningBallsFactory;

public class RankingTest {

	@Test
	public void getRankingTest() {
		Lottos lottos = Lottos.of(Arrays.asList(Lotto.of(Arrays.asList(1, 5, 11, 24, 35, 44)),
												Lotto.of(Arrays.asList(1, 5, 11, 34, 35, 41)),
												Lotto.of(Arrays.asList(4, 6, 10, 24, 35, 41)),
												Lotto.of(Arrays.asList(1, 5, 11, 34, 36, 42)),
												Lotto.of(Arrays.asList(1, 5, 11, 34, 36, 41)),
												Lotto.of(Arrays.asList(3, 7, 11, 29, 30, 41)),
												Lotto.of(Arrays.asList(3, 5, 11, 29, 30, 41)),
												Lotto.of(Arrays.asList(1, 5, 10, 11, 34, 41))));

		WinningBalls winningBalls = WinningBallsFactory.create("1,5,11,34,36,42", "10");
		List<Ranking> rankings = lottos.getRankings(winningBalls);
		assertThat(rankings).containsExactly(Ranking.FIFTH,
											 Ranking.FOURTH,
											 Ranking.FAILURE,
											 Ranking.FIRST,
											 Ranking.THIRD,
											 Ranking.FAILURE,
											 Ranking.FAILURE,
											 Ranking.SECOND);
	}

	@ParameterizedTest
	@MethodSource("rankingParameterProvider")
	public void getRankingTest2(Ranking ranking, Ranking except) {
		assertThat(ranking).isEqualTo(except);
	}

	private static Stream<Arguments> rankingParameterProvider() {
		WinningBalls winningBalls = WinningBalls.of(Lotto.of(Arrays.asList(9, 13, 19, 26, 40, 45)),
													BonusBall.of("28"));

		WinningArgument winningArgument = WinningArgument.of(Lotto.of(Arrays.asList(9, 13, 19, 26, 28, 43)),
															 winningBalls);
		WinningArgument winningArgument2 = WinningArgument.of(Lotto.of(Arrays.asList(10, 14, 19, 26, 28, 43)),
															  winningBalls);
		WinningArgument winningArgument3 = WinningArgument.of(Lotto.of(Arrays.asList(9, 13, 19, 26, 40, 45)),
															  winningBalls);
		WinningArgument winningArgument4 = WinningArgument.of(Lotto.of(Arrays.asList(9, 13, 19, 26, 40, 43)),
															  winningBalls);

		return Stream.of(
				Arguments.arguments(Ranking.getRakingOf(winningArgument), Ranking.SECOND),
				Arguments.arguments(Ranking.getRakingOf(winningArgument2), Ranking.FIFTH),
				Arguments.arguments(Ranking.getRakingOf(winningArgument3), Ranking.FIRST),
				Arguments.arguments(Ranking.getRakingOf(winningArgument4), Ranking.THIRD)
						);
	}
}

