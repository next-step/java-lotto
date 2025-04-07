package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningStatisticsCalculatorTest {

  private static Stream<Arguments> provideWinningCases() {
    return Stream.of(
        Arguments.of(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            7,
            Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10))
            ),
            Map.of(
                PrizeRank.FIRST, 1,
                PrizeRank.SECOND, 1,
                PrizeRank.THIRD, 1,
                PrizeRank.FOURTH, 1,
                PrizeRank.FIFTH, 1,
                PrizeRank.MISS, 0
            )
        ),
        Arguments.of(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            7,
            Arrays.asList(
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
            ),
            Map.of(
                PrizeRank.FIRST, 0,
                PrizeRank.SECOND, 0,
                PrizeRank.THIRD, 0,
                PrizeRank.FOURTH, 0,
                PrizeRank.FIFTH, 0,
                PrizeRank.MISS, 2
            )
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideWinningCases")
  void 당첨_통계_계산(Lotto winningNumbers, int bonusBall, List<Lotto> tickets, Map<PrizeRank, Integer> expectedCounts) {
    LottoStatistics statistics = new WinningStatisticsCalculator(winningNumbers, bonusBall).calculate(tickets);

    expectedCounts.forEach((rank, count) ->
        assertThat(statistics.getRankCounts().get(rank)).isEqualTo(count)
    );
  }
} 