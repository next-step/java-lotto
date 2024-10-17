package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningStatisticsTest {

    @DisplayName("당첨 통계 객체가 구매한 로또와 당첨 로또를 비교하여 당첨 수를 잘 반환하는지")
    @ParameterizedTest
    @MethodSource("lottoRankSummaryArguments")
    void getWinningStatistics (LotteryMachine machine, Lotto winningLotto, int[] expectedRankCounts) {
        WinningStatistics winningStatistics = new WinningStatistics(machine, winningLotto);

        assertThat(expectedRankCounts[0]).isEqualTo(winningStatistics.getRankCount(Rank.THREE_MATCHES));
        assertThat(expectedRankCounts[1]).isEqualTo(winningStatistics.getRankCount(Rank.FOUR_MATCHES));
        assertThat(expectedRankCounts[2]).isEqualTo(winningStatistics.getRankCount(Rank.FIVE_MATCHES));
        assertThat(expectedRankCounts[3]).isEqualTo(winningStatistics.getRankCount(Rank.SIX_MATCHES));
    }

    private static Stream<Arguments> lottoRankSummaryArguments() {
        LotteryMachine machine = new LotteryMachine(
                List.of(
                        new Lotto(1, 2, 3, 7, 8, 9),
                        new Lotto(1, 2, 3, 4, 5, 9),
                        new Lotto(11, 12, 13, 14, 15, 16)
                )
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int[] expectedRankCounts = {1, 0, 1, 0};
        return Stream.of(
                Arguments.of(machine, winningLotto, expectedRankCounts)
        );
    }
}
