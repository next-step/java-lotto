package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {

    @NullAndEmptySource
    @ValueSource(strings = {" "})
    @ParameterizedTest(name = "입력값이 \"{0}\" 이면 예외를 던진다.")
    void 빈값입력시예외처리(String input) {
        assertThatThrownBy(() -> new StringCalculator(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"This is wrong input","2 * 3 ^ 100"})
    @ParameterizedTest
    void 허용하지않은값예외처리(String input) {
        assertThatThrownBy(() -> new StringCalculator(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(value = {"0:+","1:*","2:/"}, delimiter = ':')
    @ParameterizedTest(name = "계산식 : '2 + 3 * 4 / 2' 에서 {0}번째 연산기호 : {1}")
    void 사칙연산구분하여담기(int index, String expectedSymbol) {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        assertThat(stringCalculator.getOperator(index)).isEqualTo(expectedSymbol);
    }

    @CsvSource(value = {"0:2", "1:3", "2:4", "3:2"}, delimiter = ':')
    @ParameterizedTest(name = "계산식 : '2 + 3 * 4 / 2' 에서 {0}번째 숫자 : {1}")
    void 숫자담기(int index, int expectedNumber) {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        assertThat(stringCalculator.getNumber(index)).isEqualTo(expectedNumber);
    }

    @CsvSource(value = {"2 + 3 * 4 / 2:10", "3 * 3 - 1 / 4:2", "2 / 2 + 8 * 3:27"}, delimiter = ':')
    @ParameterizedTest(name = "{0} = {1}")
    void 계산기테스트(String input, double expectedResult) {
        StringCalculator stringCalculator = new StringCalculator(input);
        assertThat(stringCalculator.calculate()).isEqualTo(expectedResult);
    }
}
