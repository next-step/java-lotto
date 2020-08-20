package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.factory.WinningBallsFactory;
import lotto.result.Statistics;

public class RankingStatisticsTest {

	@ParameterizedTest
	@MethodSource("rakingProvider")
	public void announcerTest(WinningBalls winBalls, Lottos lottos, Map<Ranking, Integer> expect, double rate) {
		Statistics result = Statistics.from(lottos, winBalls);
		Map<Ranking, Integer> rankingResultMap = result.getWinningResult();

		assertThat(rankingResultMap).isEqualTo(expect);
		assertThat(result.getEarningsRate()).isEqualTo(rate);
	}

	private static Stream<Arguments> rakingProvider() {
		Lottos lottos = Lottos.of(Arrays.asList(Lotto.of(LottoNumbers.of(Arrays.asList(8, 10, 13, 14, 29, 30))),
												Lotto.of(LottoNumbers.of(Arrays.asList(1, 10, 13, 14, 29, 30))),
												Lotto.of(LottoNumbers.of(Arrays.asList(1, 2, 13, 14, 29, 30))),
												Lotto.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 14, 29, 30))),
												Lotto.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 29, 30))),
												Lotto.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 30))),
												Lotto.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)))));
		Map<Ranking, Integer> expect1 = new EnumMap<>(Ranking.class);
		expect1.put(Ranking.FIFTH, 1);
		expect1.put(Ranking.FOURTH, 1);
		expect1.put(Ranking.THIRD, 1);
		expect1.put(Ranking.SECOND, 0);
		expect1.put(Ranking.FIRST, 1);

		Map<Ranking, Integer> expect2 = new EnumMap<>(Ranking.class);
		expect2.put(Ranking.FIFTH, 1);
		expect2.put(Ranking.FOURTH, 0);
		expect2.put(Ranking.THIRD, 0);
		expect2.put(Ranking.SECOND, 0);
		expect2.put(Ranking.FIRST, 0);

		Map<Ranking, Integer> expect3 = new EnumMap<>(Ranking.class);
		expect3.put(Ranking.FIFTH, 1);
		expect3.put(Ranking.FOURTH, 2);
		expect3.put(Ranking.THIRD, 0);
		expect3.put(Ranking.SECOND, 1);
		expect3.put(Ranking.FIRST, 0);

		return Stream.of(Arguments.arguments(WinningBallsFactory.create("1, 2, 3, 4, 5, 6", "10"),
											 lottos,
											 expect1,
											 new Double(285936.429)),
						 Arguments.arguments(WinningBallsFactory.create("1, 5, 10, 14, 25, 45", "10"),
											 lottos,
											 expect2,
											 new Double(0.714)),
						 Arguments.arguments(WinningBallsFactory.create("1, 2, 3, 4, 25, 45", "6"),
											 lottos,
											 expect3,
											 new Double(4300.714)));
	}
}
