package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OperatorTest {

    @Test
    void 사칙연산_덧셈() {
        Operator operator = new Operator();
        int result = operator.add("1", "2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 사칙연산_뺄셈() {
        Operator operator = new Operator();
        int result = operator.sub("3", "1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 사칙연산_곱셈() {
        Operator operator = new Operator();
        int result = operator.mul("1", "2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 사칙연산_나눗셈() {
        Operator operator = new Operator();
        int result = operator.div("4", "2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 사칙연산() {
        String[] input = {"2", "+", "3", "*", "4", "/", "2"};
        Operator operator = new Operator();
        int result = Integer.parseInt(input[0]);

        for (int i = 1; i <= Math.floor((double) input.length / 2); i++) {
            result = operator.operation(input[2 * i - 1], String.valueOf(result), input[2 * i]);
        }

        assertThat(result).isEqualTo(10);
    }
}