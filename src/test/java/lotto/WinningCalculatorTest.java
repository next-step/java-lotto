package lotto;

import lotto.domain.Winning;
import lotto.domain.WinningCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCalculatorTest {
    @Test
    @DisplayName("당첨 통계 생성 확인")
    void generateWinningCountMap() {
        List<Winning> winnings = Arrays.asList(Winning.FIFTH,
                                               Winning.FOURTH,
                                               Winning.THIRD,
                                               Winning.NONE,
                                               Winning.FIFTH,
                                               Winning.FOURTH,
                                               Winning.NONE,
                                               Winning.NONE);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);

        Map<Winning, Integer> expected = Map.of(
            Winning.FIFTH, 2,
            Winning.FOURTH, 2,
            Winning.THIRD, 1,
            Winning.SECOND, 0,
            Winning.FIRST, 0
        );
        assertThat(winningCalculator.getWinningCountMap()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 계산 확인")
    void calculateRateOfReturn() {
        List<Winning> winnings = Arrays.asList(Winning.FIFTH,
                                               Winning.FOURTH,
                                               Winning.FIFTH,
                                               Winning.NONE,
                                               Winning.FIFTH,
                                               Winning.NONE,
                                               Winning.NONE,
                                               Winning.NONE);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);

        assertThat(winningCalculator.calculateRateOfReturn()).isEqualTo(8.125);
    }
}
