package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {

    @DisplayName("enum의 정의된 연산자를 이용헤서 게산한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,3,2,5", "-,3,2,1", "*,3,2,6", "/,3,2,1"})
    void calculator(final String operator, final int number1, final int number2, final int result) {

        assertThat(Operation.from(operator).calculate(number1, number2)).isEqualTo(result);
    }

    @DisplayName("사칙연산 연산자만 존재한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void calculator(final String operator) {

        final Operation operation = Operation.from(operator);

        assertThat(operation.getOperator()).isEqualTo(operator);
    }

    @DisplayName("enum의 정의된 연산자가 아닌 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"^", "@", "!", "$"})
    void error_not_find_operator(final String operator) {

        assertThatThrownBy(() ->  Operation.from(operator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("+, -, * / 이외 다른 연산자는 불가능합니다.");
    }

    @DisplayName("0으로 나누면 익셉션 처리를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"/,3,0", "/,0,0"})
    void error_apply(final String operator, final int number1, final int number2) {

        assertThatThrownBy(() -> Operation.from(operator).calculate(number1, number2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @DisplayName("enum의 정의된 연산자를 체크한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true"})
    void find_operator(final String operator, final boolean result) {

        assertThat(Operation.match(operator)).isEqualTo(result);
    }

    @DisplayName("지원하지 않는 연산자에 대해서 익셉션 처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"^,3,2,5", "&,3,2,1", "$,3,2,6", "@,3,2,1"})
    void error_calculator(final String operator, final int number1, final int number2, final int result) {

        assertThatThrownBy(() -> Operation.from(operator).calculate(number1, number2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("+, -, * / 이외 다른 연산자는 불가능합니다.");
    }
}