package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "'1,2,3', 6",
            "'10:20:30', 60",
            "'1,2:3', 6",
            "'15:25,35', 75"
    })
    @DisplayName("기본 구분자로 결합된 0을 포함한 자연수들의 합을 계산한다.")
    void sum_NaturalNumbers_WithDefaultSeparators_Calculated(String input, int expectedResult) {
        int calculatedValue = Calculator.calculate(input);
        assertThat(calculatedValue).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "'//a\n1a2a3', 6",
            "'//!\n10!20!30', 60",
            "'//;\n15;25;35', 75"
    })
    @DisplayName("커스텀 구분자로 결합된 0을 포함한 자연수들의 합을 계산한다.")
    void sum_NaturalNumbers_WithCustomSeparators_Calculated(String input, int expectedResult) {
        int calculatedValue = Calculator.calculate(input);
        assertThat(calculatedValue).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,b,3",
            "10:20:!",
            "^,2:3",
            "15:X,,",
            "//a\n1axa3",
            "//!\nk!20!30'",
            "//;\n!;25;35'"
    })
    @DisplayName("숫자 이외의 값이 전달되면 예외를 발생시킨다.")
    void check_NotNumberParam_ExceptionThrown(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(Calculator.MESSAGE_OF_NOT_NUMBER_EXCEPTION);
    }
}
