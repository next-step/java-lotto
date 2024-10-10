package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 빈_또는_null() {
        assertThatThrownBy(() -> new StringCalculator().splitAndCalculate(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new StringCalculator().splitAndCalculate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1 + 1,2", "1 + 4,5"})
    void 합계_2개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1 + 1 + 1,3", "1 + 4 + 5 + 10,20"})
    void 합계_여러개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 1:0", "5 - 4:1", "1 - 4:-3"}, delimiter = ':')
    void 뺄셈_2개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1 - 1 - 1,-1", "10 - 1 - 4 - 50,-45"})
    void 뺄셈_여러개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1 * 1,1", "1 * 4,4"})
    void 곱하기_2개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1 * 1 * 3,3", "1 * 4 * 5 * 10,200"})
    void 곱하기_여러개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1 / 1,1", "1 / 4,0"})
    void 나누기_2개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"20 / 4, 5", "20 / 4 / 5, 1"})
    void 나누기_여러개_피연산자(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 나누기_0_에러() {
        StringCalculator calculator = new StringCalculator();
        String firstExpr = "20 / 0";

        assertThatThrownBy(() -> calculator.splitAndCalculate(firstExpr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1 + 1 * 3 / 5 - 20, -19", "1 * 4 - 5 * 10 + 1 / 10, 0"})
    void 사칙연산(String text, int expected) {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.splitAndCalculate(text);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 잘못된_연산자() {
        StringCalculator calculator = new StringCalculator();
        String expression = "1 ) 1 * 3 / 5 - 20";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 피연산자_숫자_아님() {
        StringCalculator calculator = new StringCalculator();
        String expression = "1 + a * 3 / 5 - 20";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 첫번째_문자_숫자_아님() {
        StringCalculator calculator = new StringCalculator();
        String expression = "/ 2 / 1";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expression))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 마지막_문자_숫자_아님() {
        StringCalculator calculator = new StringCalculator();
        String expression = "1 / 2 /";
        assertThatThrownBy(() -> calculator.splitAndCalculate(expression))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 숫자_뒤에_숫자() {
        StringCalculator calculator = new StringCalculator();
        String expression = "1 2 / 4";

        assertThatThrownBy(() -> calculator.splitAndCalculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}