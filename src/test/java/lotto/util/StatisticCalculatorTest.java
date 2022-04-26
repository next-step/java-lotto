package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.*;

class StatisticCalculatorTest {

    @Test
    void calculateRateTest() {
        assertThat(StatisticCalculator.calculateRate(14_000, List.of(FIFTH)))
                .isEqualTo(0.35);
    }

}