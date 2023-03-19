package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class CalculatorTest {
    @DisplayName("문자열을 전달하면 쉼표(,) 또는 콜론(:)을 기준으로 자른다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3,4"})
    void parse(String input) {
        Calculator calculator = new Calculator();
        assertThat(Arrays.toString(calculator.parse(input))).isEqualTo("[1, 2, 3, 4]");
    }

    @DisplayName("기본 구분자 외의 \"//\", \"\\n\"로 커스텀 구분자를 지정해서 문자열을 자른다")
    @ParameterizedTest
    @ValueSource(strings = {"1//;\n2:3,4"})
    void parse2(String input) {
        Calculator calculator = new Calculator();
        assertThat(Arrays.toString(calculator.parse(input))).isEqualTo("[1, 2, 3, 4]");
    }

    @DisplayName("숫자 이외의 값 또는 음수는 RuntimeException throw 한다")
    @ParameterizedTest
    @ValueSource(strings = {"-:1,2","-1", "#"})
    void exceptionHandle(String input) {
        Calculator calculator = new Calculator();
        String[] values = calculator.parse(input);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.calculator(values));
    }
    @DisplayName("빈 문자열의 경우 0을 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void calculator(String input) {
        int result = 0;
        Calculator calculator = new Calculator();
        String[] values = calculator.parse(input);
        result = calculator.calculator(values);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("자른 문자열 배열을 받아 합한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2 | 3","1,2,3 | 6", "1,2:3 | 6"}, delimiter = '|')
    void calculator2(String input, int expected) {
        int result = 0;
        Calculator calculator = new Calculator();
        String[] values = calculator.parse(input);
        result = calculator.calculator(values);
        assertThat(result).isEqualTo(expected);
    }
}
