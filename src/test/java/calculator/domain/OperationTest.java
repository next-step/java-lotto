package calculator.domain;

import org.assertj.core.api.Assertions;
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
    void apply(final String operator, final int number1, final int number2, final int result) {

        Assertions.assertThat(Operation.from(operator).apply(number1, number2)).isEqualTo(result);
    }

    @DisplayName("enum의 정의된 연산자를 이용헤서 게산한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void find_operator(final String operator) {

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
}