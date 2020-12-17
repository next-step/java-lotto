package step2;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateCalculatorTest {

    @Test
    public void 계산_테스트() {
        double rate = RateCalculator.calculate(Money.of(5000), Money.of(14000));
        assertThat(rate).isEqualTo(0.35);
    }
}
