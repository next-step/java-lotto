package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-05
 */
class CalculatorTest {

    @Test
    void 연산() {
        Calculator calculator = new Calculator();
        calculator.calculate(5);
        calculator.set(Operator.PLUS);
        calculator.calculate(5);
        calculator.set(Operator.MINUS);
        calculator.calculate(3);

        assertThat(calculator.getResult()).isEqualTo(7);
    }
}