package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Calculator는 객체를 생성할 수 있다.")
    void create_Calculator() {
        Calculator calculator = new Calculator();
        assertThat(calculator).isInstanceOf(Calculator.class);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3', 6",
            "'10:20:30', 60",
            "'1,2:3', 6",
            "'15:25,35', 75"
    })
    @DisplayName("기본 구분자로 결합된 0을 포함한 자연수들의 합을 계산한다.")
    void sum_NaturalNumbers_WithDefaultSeparators_Calculated(String input, int expectedResult) {
        int calculatedValue = calculator.calculate(input);
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
        int calculatedValue = calculator.calculate(input);
        assertThat(calculatedValue).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("null이 입력되면 0으로 계산한다.")
    void sum_Null_Calculated() {
        int calculatedValue = calculator.calculate(null);
        assertThat(calculatedValue).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ",
            "   ",
            "       "
    })
    @DisplayName("빈 문자열이 입력되면 0으로 계산한다.")
    void sum_Empty_Calculated(String input) {
        int calculatedValue = calculator.calculate(input);
        assertThat(calculatedValue).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나가 입력되면 입력된 숫자로 계산한다.")
    void sum_OneParam_Calculated() {
        String input = "10";
        int calculatedValue = calculator.calculate(input);
        assertThat(calculatedValue).isEqualTo(Integer.valueOf(input));
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
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Operand.MESSAGE_OF_NOT_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,-1,3",
            "10:20:-30",
            "-4,2:3",
            "15:-5,-1,",
            "//a\n1a-14a3",
            "//!\n-1!20!30",
            "//;\n-9;25;35"
    })
    @DisplayName("음수 값이 전달되면 예외를 발생시킨다.")
    void check_NegativeNumberParam_ExceptionThrown(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Operand.MESSAGE_OF_NEGATIVE_NUMBER_EXCEPTION);
    }
}
