package lotto;

import lotto.domain.Statistics;
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
        statistics.put(3, 1);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);

        assertThat(winningRules.getTotalRateOfReturn(14000, statistics)).isEqualTo(BigDecimal.valueOf(0.35));
    }
}
