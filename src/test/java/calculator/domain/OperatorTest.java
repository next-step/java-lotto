package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("입력 연산식이 빈 공간이 없는 경우 익셉션 처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"*2", "3*2", "2*"})
    void error_no_blank_number_operator(final String input) {

        assertThatThrownBy(() -> new Operator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산식의 숫자 또는 연산자 사이에 빈 공간이 없습니다.");
    }

    @DisplayName("사칙연산이 아닌 경우 익셉션 처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"^", "%", "$"})
    void error_not_operator(final String input) {

        assertThatThrownBy(() -> new Operator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("+, -, * / 이외 다른 연산자는 불가능합니다.");
    }
}
