package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @DisplayName("입력 연산식이 빈 값 또는 null 값인 경우 익셉션 처리한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void error_null_empty(final String input) {

        assertThatThrownBy(() -> StringAddCalculator.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 또는 빈 공백 입니다.");
    }

    @DisplayName("입력 연산식이 빈 공간이 없는 경우 익셉션 처리한다.")
    @ParameterizedTest
    @CsvSource(value = {"3 *2", "3*2", "3 *2"})
    void error_no_blank_number_operator(final String input) {

        final StringAddCalculator 계산기 = StringAddCalculator.from(input);
        assertThatThrownBy(() -> 계산기.calculator())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산식의 숫자 또는 연산자 사이에 빈 공간이 없습니다.");
    }

    @DisplayName("사칙연산(+, -, *, /)만 연산이 가능하다.")
    @ParameterizedTest
    @CsvSource(value = {"3 + 2, 5", "3 - 2, 1", "3 * 2, 6", "3 / 2, 1"})
    void four_operation(final String input, final int result) {

        final StringAddCalculator 계산기 = StringAddCalculator.from(input);

        assertThat(계산기.calculator()).isEqualTo(result);
    }

    @DisplayName("완전한 계산식이 아닌 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3 * 2 2", "3 * 2 *"})
    void error_not_complete_expression(final String input) {

        final StringAddCalculator 계산기 = StringAddCalculator.from(input);

        assertThatThrownBy(() -> 계산기.calculator())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산기를 잘못 입력하였습니다.");
    }

    @DisplayName("지원하지 않는 연산자에 대해서 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3 ^ 2", "3 & 2", "3 @ 2"})
    void error_not_support_operation(final String input) {

        final StringAddCalculator 계산기 = StringAddCalculator.from(input);

        assertThatThrownBy(() -> 계산기.calculator())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("+, -, * / 이외 다른 연산자는 불가능합니다.");
    }
}
