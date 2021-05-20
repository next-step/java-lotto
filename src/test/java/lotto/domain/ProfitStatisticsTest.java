package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitStatisticsTest {

    @Test
    @DisplayName("수익률 계산")
    void calculateProfit() {
        long inputPrice = 14000L;
        WinningResults winningResults = new WinningResults(Arrays.asList(WinningType.FOURTH));
        Money inputMoney = Money.from(inputPrice);

        ProfitStatistics profitStatistics = new ProfitStatistics(winningResults, inputMoney);

        assertThat(profitStatistics.calculateProfitRate()).isEqualTo(0.35);
    }
}
