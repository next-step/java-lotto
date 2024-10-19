package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningStatisticsTest {

    @DisplayName("당첨 통계 객체가 구매한 로또와 당첨 로또를 비교하여 당첨 수를 잘 반환하는지")
    @ParameterizedTest
    @MethodSource("lottoRankSummaryArguments")
    void getWinningStatistics (LotteryMachine machine, Lotto winningLotto, int[] expectedRankCounts) {
        WinningStatistics winningStatistics = new WinningStatistics(machine, winningLotto, new LottoNumber(45));

        assertThat(expectedRankCounts[0]).isEqualTo(winningStatistics.getRankCount(Rank.THREE_MATCHES));
        assertThat(expectedRankCounts[1]).isEqualTo(winningStatistics.getRankCount(Rank.FOUR_MATCHES));
        assertThat(expectedRankCounts[2]).isEqualTo(winningStatistics.getRankCount(Rank.FIVE_MATCHES));
        assertThat(expectedRankCounts[3]).isEqualTo(winningStatistics.getRankCount(Rank.FIVE_MATCHES_WITH_BONUS));
        assertThat(expectedRankCounts[4]).isEqualTo(winningStatistics.getRankCount(Rank.SIX_MATCHES));
    }

    private static Stream<Arguments> lottoRankSummaryArguments() {
        LotteryMachine machine = new LotteryMachine(
                List.of(
                        new Lotto(1, 2, 3, 7, 8, 9),
                        new Lotto(1, 2, 3, 4, 5, 9),
                        new Lotto(1, 2, 3, 4, 5, 45),
                        new Lotto(11, 12, 13, 14, 15, 16)
                )
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int[] expectedRankCounts = {1, 0, 1, 1, 0};
        return Stream.of(
                Arguments.of(machine, winningLotto, expectedRankCounts)
        );
    }

    @DisplayName("당첨 통계 객체가 구매한 로또와 당첨 로또를 비교하여 수익률을 잘 반환하는지")
    @ParameterizedTest
    @MethodSource("lottoRankProfitArguments")
    void getWinningStatistics (LotteryMachine machine, Lotto winningLotto, double profitRate) {
        WinningStatistics winningStatistics = new WinningStatistics(machine, winningLotto, new LottoNumber(45));

        assertThat(profitRate).isEqualTo(winningStatistics.calculateProfitRate());
    }

    private static Stream<Arguments> lottoRankProfitArguments() {
        LotteryMachine machine = new LotteryMachine(
                List.of(
                        new Lotto(1, 2, 3, 7, 8, 9)
                )
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        double profitRate = 5.00;
        return Stream.of(
                Arguments.of(machine, winningLotto, profitRate)
        );
    }

    @DisplayName("당첨 통계가 생성되었을 때, 보너스 번호와 당첨 로또의 번호가 겹치면 예외가 발생하는지")
    @Test
    void createWinningStatisticsWithBonusBall() {
        LotteryMachine machine = new LotteryMachine(
                List.of(
                        new Lotto(1, 2, 3, 4, 5, 6)
                )
        );
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatThrownBy(() -> new WinningStatistics(machine, winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
