package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.StringCalculator.splitAndCalculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringCalculatorTest {

    @Test
    void 입력값_공백() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    splitAndCalculate(null);
                }).withMessageMatching("입력값이 null 또는 빈 공백 문자입니다.");
    }

    @Test
    void 입력값_빈문자열() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    splitAndCalculate("");
                }).withMessageMatching("입력값이 null 또는 빈 공백 문자입니다.");
    }

    @Test
    void 입력값_사칙연산기호_아닌경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            splitAndCalculate("1 X 3");
        }).withMessageMatching("사칙연산 기호가 아닌 문자는 허용되지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3:4", "2 + 6:8"}, delimiter = ':')
    void 사칙연산_덧셈(String expression, int expected) {
        int result = splitAndCalculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6 - 3:3", "8 - 2:6"}, delimiter = ':')
    void 사칙연산_뺄셈(String expression, int expected) {
        int result = splitAndCalculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6 * 4:24", "8 * 2:16"}, delimiter = ':')
    void 사칙연산_곱셈(String expression, int expected) {
        int result = splitAndCalculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6 / 3:2", "8 / 2:4"}, delimiter = ':')
    void 사칙연산_나눗셈(String expression, int expected) {
        int result = splitAndCalculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 사칙연산_모두포함() {
        int result = splitAndCalculate("10 - 3 + 3 * 2 / 4");
        assertThat(result).isEqualTo(5);
    }
}
