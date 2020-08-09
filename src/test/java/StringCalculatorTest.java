import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "2,3,4=9"}, delimiter = '=')
    @DisplayName("쉼표가 구분자일 때 덧셈 결과 값을 반환한다.")
    void plusTest1(String input, int expected) {
        int result = calculator.calculate(input, ",");

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3=6", "2:3:4=9"}, delimiter = '=')
    @DisplayName("콜론이 구분자일 때 덧셈 결과 값을 반환한다.")
    void plusTest2(String input, int expected) {
        int result = calculator.calculate(input, ":");

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=;", "//^\\n1^2^3=^"}, delimiter = '=')
    @DisplayName("커스텀 구분자를 추출한다")
    void getDelimiter(String input, String expected) {
        List<String> delimiterAndInput = calculator.getDelimiterAndInput(input);

        assertThat(delimiterAndInput.get(0)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3=6", "//^\\n1^2^3=6"}, delimiter = '=')
    @DisplayName("커스텀 구분자가 있으면 추출해 덧셈 결과 값을 반환한다.")
    void plusTest3(String inputStr, int expected) {
        List<String> delimiterAndInput = calculator.getDelimiterAndInput(inputStr);

        String delimiter = delimiterAndInput.get(0);
        String input = delimiterAndInput.get(1);

        int actual = calculator.calculate(input, delimiter);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1;2;3=6", "1;h;3"})
    void exceptionTest(String input) {

        assertThatThrownBy(() -> calculator.calculate(input, ";"))
                .isInstanceOf(RuntimeException.class);
    }

}