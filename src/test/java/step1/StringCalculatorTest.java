package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열이 비어있는 경우 0 리턴")
    void returnZeroEmptyTest() {
        assertThat(stringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열이 Null인 경우 0 리턴")
    void returnZeroNullTest() {
        assertThat(stringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열에 숫자가 하나인 경우 해당 숫자 리턴")
    void returnOneNumberTest() {
        String text = "3";
        assertThat(stringCalculator.calculate(text)).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열에 콤마 구분자가 있을 경우 문자열 합 리턴")
    void onlyCommaDelimiterTest() {
        String text = "3,5";
        assertThat(stringCalculator.calculate(text)).isEqualTo(8);
    }

    @Test
    @DisplayName("문자열에 콤마와 콜론 구분자가 섞여있을 경우 문자열 합 리턴")
    void commaAndColonDelimiterTest() {
        String text = "3,5:6";
        assertThat(stringCalculator.calculate(text)).isEqualTo(14);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정하는 경우 문자열의 합 리턴 - 구분자(;)")
    void customDelimiterSemicolonTest() {
        String text = "//;\n1;2;3";
        assertThat(stringCalculator.calculate(text)).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정하는 경우 문자열의 합 리턴 - 구분자(-)")
    void customDelimiterDashTest() {
        String text = "//-\n1-2-3";
        assertThat(stringCalculator.calculate(text)).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열이 음수인 경우 예외 처리 - 단일 문자열인 경우")
    void minusOnlyOneStringExceptionTest() {
        String text = "-1";
        Assertions.assertThrows(RuntimeException.class,
                () -> stringCalculator.calculate(text));
    }

    @Test
    @DisplayName("문자열이 음수인 경우 예외 처리 - 여러 문자열 중 음수인 경우")
    void minusMultipleStringExceptionTest() {
        String text = "1;2;-3";
        Assertions.assertThrows(RuntimeException.class,
                () -> stringCalculator.calculate(text));
    }

    @Test
    @DisplayName("숫자인 문자열이 아닌 경우 예외 처리 - 단일 문자열인 경우")
    void notNumberOnlyOneExceptionTest() {
        String text = "a";
        Assertions.assertThrows(RuntimeException.class,
                () -> stringCalculator.calculate(text));
    }

    @Test
    @DisplayName("숫자인 문자열이 아닌 경우 예외 처리 - 여러 문자열 중 숫자가 아닌 경우")
    void notNumberMultipleExceptionTest() {
        String text = "1,2,b";
        Assertions.assertThrows(RuntimeException.class,
                () -> stringCalculator.calculate(text));
    }

}