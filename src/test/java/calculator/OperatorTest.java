package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.ErrorMessage.INVALID_NUMBER;
import static util.ErrorMessage.INVALID_OPERATOR;

public class OperatorTest {

    @Test
    @DisplayName("연산자 기호에 따라 적절한 연산을 수행한다")
    void operator_apply_correctly() {
        assertThat(Operator.from("+").apply(2, 3)).isEqualTo(5);
        assertThat(Operator.from("-").apply(5, 2)).isEqualTo(3);
        assertThat(Operator.from("*").apply(4, 2)).isEqualTo(8);
        assertThat(Operator.from("/").apply(10, 2)).isEqualTo(5);
    }

    @Test
    @DisplayName("0으로 나눌 경우 예외를 던진다")
    void divide_by_zero_should_throw_exception() {
        assertThatThrownBy(() -> Operator.from("/").apply(10, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage(INVALID_NUMBER);
    }

    @Test
    @DisplayName("정의되지 않은 연산자는 예외를 던진다")
    void invalid_operator_should_throw_exception() {
        assertThatThrownBy(() -> Operator.from("&"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_OPERATOR);
    }

    @Test
    @DisplayName("나눗셈은 정수 나눗셈으로 처리되며, 나머지는 버려진다")
    void division_should_be_integer_division() {
        assertThat(Operator.from("/").apply(7, 3)).isEqualTo(2);
        assertThat(Operator.from("/").apply(9, 4)).isEqualTo(2);
    }
}
