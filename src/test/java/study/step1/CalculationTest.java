package study.step1;

import org.junit.jupiter.api.Test;
import study.step1.domain.DefaultCalculation;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTest {

    @Test
    void 더하기() {
        DefaultCalculation calculator = new DefaultCalculation();
        assertThat(calculator.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void 빼기() {
        DefaultCalculation calculator = new DefaultCalculation();
        assertThat(calculator.minus(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱하기() {
        DefaultCalculation calculator = new DefaultCalculation();
        assertThat(calculator.times(1, 2)).isEqualTo(2);
    }

    @Test
    void 나누기() {
        DefaultCalculation calculator = new DefaultCalculation();
        assertThat(calculator.divide(1, 2)).isEqualTo(0);
        assertThat(calculator.divide(2, 2)).isEqualTo(1);
    }

}
