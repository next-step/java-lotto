package calculator;

import calculator.domain.Calculator;
import calculator.domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 사칙연산() {
        String[] input = {"2", "+", "3", "*", "4", "/", "2"};
        Operator operator = new Operator();
        Calculator calculator = new Calculator();
        int result1 = Integer.parseInt(input[0]);

        for (int i = 1; i <= Math.floor((double) input.length / 2); i++) {
            result1 = operator.operation(input[2 * i - 1], String.valueOf(result1), input[2 * i]);
        }
        Integer result2 = calculator.calculation(input);

        assertThat(result1).isEqualTo(10);
        assertThat(result2).isEqualTo(10);
    }

}