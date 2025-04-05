package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.ErrorMessage.*;

public class OperatorTest {

    @DisplayName("연산자 기호에 따라 적절한 연산을 수행한다")
    @ParameterizedTest
    @CsvSource({
            "+,2,3,5",
            "-,5,2,3",
            "*,4,2,8",
            "/,10,2,5"
    })
    void apply_operator_correctly(String operator, int a, int b, int expected) {
        assertThat(Operator.from(operator).apply(a, b)).isEqualTo(expected);
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

    @DisplayName("나눗셈은 정수 나눗셈으로 처리되며, 나머지는 버려진다")
    @ParameterizedTest
    @CsvSource({
            "7,3,2",
            "9,4,2"
    })
    void division_should_ignore_remainder(int a, int b, int expected) {
        assertThat(Operator.from("/").apply(a, b)).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 숫자 자리에 올 경우 NumberFormatException 발생시킨다")
    void invalid_number_should_throw_exception() {
        Calculator calculator = Calculator.create();

        assertThatThrownBy(() -> calculator.run("a + 3"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(INVALID_STRING);
    }

    @DisplayName("지원하는 연산자인 경우 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void true_should_be_true(String operator) {
        assertThat(Operator.isSupported(operator)).isTrue();
    }

    @DisplayName("지원하지 않는 연산자인 경우 false 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "$", "#"})
    void true_should_be_false(String operator) {
        assertThat(Operator.isSupported(operator)).isFalse();
    }


    @DisplayName("유효한 연산자를 입력한 경우 Operator 객체를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void return_operator(String operator) {
        Operator result = Operator.from(operator);
        assertThat(result.getSymbol()).isEqualTo(operator);
    }

    @DisplayName("유효하지 않은 연산자를 입력한 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"&", "%", "^", "#"})
    void  return_exception(String operator) {
        assertThatThrownBy(() -> Operator.from(operator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_OPERATOR);
    }
}
