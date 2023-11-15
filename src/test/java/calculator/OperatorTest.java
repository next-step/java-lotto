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
}