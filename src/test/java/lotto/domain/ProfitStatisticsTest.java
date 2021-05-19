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
        WinningResult winningResult = new WinningResult(Arrays.asList(WinningType.FOURTH));
        Money inputMoney = Money.from(inputPrice);

        ProfitStatistics profitStatistics = new ProfitStatistics(winningResult, inputMoney);

        assertThat(profitStatistics.calculateProfitRate()).isEqualTo(0.35);
    }
}
