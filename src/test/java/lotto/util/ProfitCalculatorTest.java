package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitCalculatorTest {

    @Test
    void 수익률_소수점_둘째짜리까지_계산() {
        double profitRate = ProfitCalculator.calculateProfitRate(14000, 5000);
        assertThat(profitRate).isEqualTo(0.35);
    }

}
