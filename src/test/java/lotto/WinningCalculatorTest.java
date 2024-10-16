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
        List<Winning> winnings = Arrays.asList(Winning.THREE_MATCH,
                                               Winning.FOUR_MATCH,
                                               Winning.FIVE_MATCH,
                                               Winning.NONE,
                                               Winning.THREE_MATCH,
                                               Winning.FOUR_MATCH,
                                               Winning.NONE,
                                               Winning.NONE);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);

        Map<Winning, Integer> expected = Map.of(
            Winning.THREE_MATCH, 2,
            Winning.FOUR_MATCH, 2,
            Winning.FIVE_MATCH, 1,
            Winning.SIX_MATCH, 0
        );
        assertThat(winningCalculator.getWinningCountMap()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 계산 확인")
    void calculateRateOfReturn() {
        List<Winning> winnings = Arrays.asList(Winning.THREE_MATCH,
                                               Winning.FOUR_MATCH,
                                               Winning.THREE_MATCH,
                                               Winning.NONE,
                                               Winning.THREE_MATCH,
                                               Winning.NONE,
                                               Winning.NONE,
                                               Winning.NONE);
        WinningCalculator winningCalculator = new WinningCalculator(winnings);

        assertThat(winningCalculator.calculateRateOfReturn()).isEqualTo(8.125);
    }
}
