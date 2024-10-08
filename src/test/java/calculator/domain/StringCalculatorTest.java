package calculator.domain;

import calculator.strategy.CalculationOrderStrategy;
import calculator.strategy.LeftToRight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        CalculationOrderStrategy calculationOrderStrategy = new LeftToRight();
        this.calculator = new StringCalculator(calculationOrderStrategy);
    }

    @Test
    void 숫자_하나() {
        Strings strings = new Input("10").split();
        assertThat(calculator.calculate(strings)).isEqualTo(new Operand("10"));
    }

    @Test
    void 문자열_계산() {
        Strings strings = new Input("2 + 3 * 4 / 2").split();
        assertThat(calculator.calculate(strings)).isEqualTo(new Operand("10"));
    }
}
