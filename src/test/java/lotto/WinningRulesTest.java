package lotto;

import lotto.domain.Statistics;
import lotto.domain.WinningRule;
import lotto.domain.WinningRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRulesTest {

    @Test
    @DisplayName("총 수익률을 계산한다.")
    void testTotalRateOfReturn() {
        WinningRules winningRules = WinningRules.getDefaultWinningRules();

        Statistics statistics = new Statistics();
        statistics.put(WinningRule.THREE, 1);
        statistics.put(WinningRule.FOUR, 0);
        statistics.put(WinningRule.FIVE, 0);
        statistics.put(WinningRule.SIX, 0);

        assertThat(winningRules.getTotalRateOfReturn(14000, statistics)).isEqualTo(BigDecimal.valueOf(0.35));
    }
}
