package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateUtilsTest {
    private final double total = 14000;
    private final double val = 5000;

    @Test
    @DisplayName("수익률 계산")
    public void getRateTest() {

        double result = RateUtils.getRate(total, val);

        double expected = 0.35;
        assertThat(result).isBetween(expected, expected + 0.01);
    }

    @Test
    @DisplayName("수익률 퍼센트 계산")
    public void getRatePcTest() {
        double result = RateUtils.getRatePc(total, val);

        double expected = 35;
        assertThat(result).isBetween(expected, expected + 1);
    }

}