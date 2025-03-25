package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class OperatorTest {
    @Test
    @DisplayName("사칙연산 기호가 아닌 값이 입력되었을 때 예외를 발생시킨다.")
    void nonOperatorTest() {
        assertThatThrownBy(() -> {
            Operator operator = new Operator("a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 기호가 아닙니다. 값 : a");
    }

    @ParameterizedTest
    @DisplayName("사칙연산을 제대로 하는지 확인한다")
    @CsvSource(value = {"+:4", "-:0", "*:4", "/:1"}, delimiter = ':')
    void operatorTest(String value, int expected) {
        Operator operator = new Operator(value);
        assertThat(operator.apply(2, 2)).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나누기 연산이 발생했을 때 예외를 발생시킨다.")
    void divideByZeroTest() {
        assertThatThrownBy(() -> {
            Operator operator = new Operator("/");
            operator.apply(2, 0);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("나눈 값이 정수가 아닌 경우 예외를 발생시킨다.")
    void divideByNotIntegerTest() {
        assertThatThrownBy(() -> {
            Operator operator = new Operator("/");
            operator.apply(3, 2);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("나눗셈의 결과가 정수가 아닙니다.");
    }
}
