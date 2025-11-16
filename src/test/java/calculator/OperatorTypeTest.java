package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTypeTest {

    @Test
    void 덧셈연산을_수행한다() {
        OperatorType operator = OperatorType.from("+");
        int result = operator.calculate(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈연산을_수행한다() {
        OperatorType operator = OperatorType.from("-");
        int result = operator.calculate(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱셈연산을_수행한다() {
        OperatorType operator = OperatorType.from("*");
        int result = operator.calculate(3, 4);
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 나눗셈연산을_수행한다() {
        OperatorType operator = OperatorType.from("/");
        int result = operator.calculate(8, 2);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 잘못된_연산자는_예외를_발생시킨다() {
        assertThatThrownBy(() -> OperatorType.from("&"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원하지 않는 연산자");
    }

}
