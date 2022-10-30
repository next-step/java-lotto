package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitCalculatorTest {

    @Test
    @DisplayName("모든 등수에 한번씩 당첨")
    void calculate() {
        Map<Prize, Integer> result = Map.of(
                Prize.NONE, 1,
                Prize.THREE, 1,
                Prize.FOUR, 1,
                Prize.FIVE, 1,
                Prize.SIX, 1
        );

        float profit = new LottoProfitCalculator(1, result).calculate();
        assertThat(profit).isEqualTo(
                Prize.THREE.getValue()
                        + Prize.FOUR.getValue()
                        + Prize.FIVE.getValue()
                        + Prize.SIX.getValue());
    }

    @Test
    @DisplayName("당첨된 번호 없음")
    void calculate_zero() {
        Map<Prize, Integer> result = Map.of(Prize.NONE, 1000);

        float profit = new LottoProfitCalculator(10000, result).calculate();
        assertThat(profit).isEqualTo(0);
    }

    @Test
    @DisplayName("이득은 총 상금 / price")
    void calculate_profit() {
        Map<Prize, Integer> result = Map.of(Prize.FIVE, 3);

        float profit = new LottoProfitCalculator(77, result).calculate();
        assertThat(profit).isEqualTo((float) (Prize.FIVE.getValue() * 3) / 77);
    }
}
