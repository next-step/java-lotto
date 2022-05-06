package calculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void 잘못된_연산자를_생성할_경우() {
        final String NOT_OPERATOR = "!";

        assertThatThrownBy(() -> Operator.create(NOT_OPERATOR))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_OPERATOR);
    }

    @Test
    void 더하기_계산_성공() {
        Operator operator = Operator.create("+");
        assertThat(operator.calculate(new Number(1), new Number(3)).getNumber()).isEqualTo(4);
    }

    @Test
    void 뺄셈_계산_성공() {
        Operator operator = Operator.create("-");
        assertThat(operator.calculate(new Number(3), new Number(1)).getNumber()).isEqualTo(2);
    }

    @Test
    void 곱하기_계산_성공() {
        Operator operator = Operator.create("*");
        assertThat(operator.calculate(new Number(3), new Number(2)).getNumber()).isEqualTo(6);
    }

    @Test
    void 나누기_계산_성공() {
        Operator operator = Operator.create("/");
        assertThat(operator.calculate(new Number(6), new Number(2)).getNumber()).isEqualTo(3);
    }
}
