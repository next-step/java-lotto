package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {
    @Test
    void 미당첨_수익률() {
        Map<WinningType, Integer> winningResult = new HashMap<>();
        winningResult.put(WinningType.NOT_WINNING, 4);
        Money money = new Money("4000");

        Statistics statistics = new Statistics(winningResult);
        assertThat(statistics.getRateOfReturn(money)).isEqualTo(0);
    }

    @Test
    void 당첨_수익률() {
        Map<WinningType, Integer> winningResult = new HashMap<>();
        winningResult.put(WinningType.FOURTH_PLACE, 1);
        Money money = new Money("5000");

        Statistics statistics = new Statistics(winningResult);
        assertThat(statistics.getRateOfReturn(money)).isEqualTo(1);
    }
}
