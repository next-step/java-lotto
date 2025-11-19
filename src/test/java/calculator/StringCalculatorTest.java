package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void 사칙연산을_계산할_수_있다() {
        StringCalculator calculator = new StringCalculator(new CalculatorFactory());

        assertThat(
                calculator.calculate("2 + 3 * 4 / 2")
        ).isEqualTo(10);
    }
}