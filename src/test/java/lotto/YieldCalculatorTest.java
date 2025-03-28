package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class YieldCalculatorTest {
    @Test
    @DisplayName("당첨 통계에 따라 수익률을 올바르게 계산한다")
    void calculateYield_returnsCorrectYield() {
        // given
        var result = Map.of(
                3L, 2L,  // 5천원 * 2
                4L, 1L,  // 5만원 * 1
                5L, 0L,
                6L, 1L   // 20억 * 1
        );

        long totalInvestment = 4 * 1000L; // 총 4장 구매
        long totalWinningAmount = (2 * 5_000L) + (50_000L) + (2_000_000_000L);

        double expectedYield = ((double) totalWinningAmount / totalInvestment) * 100;

        double yield = YieldCalculator.calculateYield(result);

        Assertions.assertThat(yield).isEqualTo(expectedYield);
    }
}