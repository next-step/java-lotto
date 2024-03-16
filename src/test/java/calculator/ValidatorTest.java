package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:true", "1 + 2 - 3:true", "1 + 2 - 3 * 4:true", "1 + 2 - 3 / 4 * 5:true", "1 + 2 -3:false", "1 +2 *3:false", "1/ 2:false"}, delimiter = ':')
    @DisplayName("숫자와 사칙 연산 사이에는 반드시 빈 공백 문자가 존재해야한다.")
    void test_수식_공백_테스트(String input, boolean expected) {
        assertThat(Validator.hasBlankBetweenNumberAndOperand(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"     "})
    @DisplayName("입력으로 NULL이나 빈 문자열이 주어진 경우 false를 반환한다.")
    void test_입력_공백_테스트(String input) {
        assertThat(Validator.isNonBlankInput(input)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "1 + 2:true", "1 + :false"}, delimiter = ':')
    @DisplayName("공백을 제외한 연산자와 피연산자의 총 개수는 최소 3개여야 한다.")
    void test_연산자_피연산자_최소조합개수(String input, boolean expected) {
        assertThat(Validator.minNumberOfTokens(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"+ 1:false", "1 * :false", "/ :false", "1 + 2:true", "1 * 2 /:false"}, delimiter = ':')
    @DisplayName("입력된 문자열의 시작과 끝은 숫자여야 한다.")
    void test_문자열_시작과끝_검증(String input, boolean expected) {
        assertThat(Validator.isValidStartAndLastNumber(input)).isEqualTo(expected);
    }
}