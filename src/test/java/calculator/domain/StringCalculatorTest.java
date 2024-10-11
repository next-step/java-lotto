package calculator.domain;

import calculator.strategy.InputOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new StringCalculator(new InputOrder());
    }

    @Test
    void 숫자_하나() {
        assertThat(calculator.calculate(new Input("10").split())).isEqualTo(10);
    }

    @Test
    void 문자열_계산() {
        assertThat(calculator.calculate(new Input("2 + 3 * 4 / 2").split())).isEqualTo(10);
    }
}
