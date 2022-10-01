package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperationTest {

    @DisplayName("입력 문자열의 사칙 연산을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,3,2,5", "-,3,2,1", "*,3,2,6", "/,3,2,1"})
    void calculator(final String operation, final int number1, final int number2, final int result) {

        assertThat(Operation.from(operation).calculate(number1, number2)).isEqualTo(result);
    }

    @DisplayName("사칙연산자가 아닌 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"^", "@", "!", "$"})
    void error_not_find_operation(final String operation) {

        assertThatThrownBy(() ->  Operation.from(operation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("+, -, * / 이외 다른 연산자는 불가능합니다.");
    }

    @DisplayName("0으로 나누면 익셉션 처리를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"/,3,0", "/,0,0"})
    void error_apply(final String operation, final int number1, final int number2) {

        assertThatThrownBy(() -> Operation.from(operation).calculate(number1, number2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @DisplayName("사칙연산 연산자만 존재한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true"})
    void find_operation(final String operation, final boolean result) {

        assertThat(Operation.match(operation)).isEqualTo(result);
    }

    @DisplayName("지원하지 않는 연산자에 대해서 익셉션 처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"^,3,2,5", "&,3,2,1", "$,3,2,6", "@,3,2,1"})
    void error_calculator(final String operation, final int number1, final int number2, final int result) {

        assertThatThrownBy(() -> Operation.from(operation).calculate(number1, number2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("+, -, * / 이외 다른 연산자는 불가능합니다.");
    }

    @DisplayName("입력 연산식이 빈 공간이 없는 경우 익셉션 처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"*2", "3*2", "2*"})
    void error_no_blank_number_operation(final String input) {

        assertThatThrownBy(() -> Operation.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산식의 숫자 또는 연산자 사이에 빈 공간이 없습니다.");
    }

    @DisplayName("사칙연산이 아닌 경우 익셉션 처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"^", "%", "$"})
    void error_not_operation(final String input) {

        assertThatThrownBy(() -> Operation.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("+, -, * / 이외 다른 연산자는 불가능합니다.");
    }
}