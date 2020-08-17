package stringcalculator.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.TestInputUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionValidatorTest {
    @DisplayName("문자열 덧셈식 검사")
    @ParameterizedTest
    @CsvSource(value = {"1:2,3;true", "//?\\n1?2?3;true", "1::2;3;false", "\\n1?2?3;false", " ;false"}, delimiter = ';')
    void validateExpression(String value, boolean expected) {
        //given
        String expressionValue = TestInputUtils.replaceLinefeed(value);

        //when
        boolean actual = ExpressionValidator.validExpression(expressionValue);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validateExpression2() {
        //given
        String expressionValue = "//?\n1?2?3";

        //when
        boolean actual = ExpressionValidator.validExpression(expressionValue);

        // then
        assertEquals(true, actual);
    }

    @DisplayName("문자열 덧셈식 검사 - 정상적인 문자열 덧셈식")
    @ParameterizedTest
    @ValueSource(strings = {"1:2;3", "//?\n1?2?3"})
    void validateNormalExpression(String value) {
        //given
        String expressionValue = TestInputUtils.replaceLinefeed(value);

        //when
        boolean actual = ExpressionValidator.validExpression(expressionValue);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("문자열 덧셈식 검사 - 잘못된 문자열 덧셈식")
    @ParameterizedTest
    @ValueSource(strings = {"1::2;3", "\\n1?2?3", " "})
    void validateWrongExpression(String value) {
        //given
        String expressionValue = TestInputUtils.replaceLinefeed(value);

        //when
        boolean actual = ExpressionValidator.validExpression(expressionValue);
        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("문자열 덧셈식 검사 - null 입력")
    @Test
    void newInstanceWithNullValue() {
        //when
        boolean actual = ExpressionValidator.validExpression(null);
        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("문자열덧셈식 요소 검사 - 0 이상 숫자인 경우 true, 음수이거나 숫자가 아닌경우 false")
    @ParameterizedTest
    @CsvSource(value = {"0,true", "-1,false", ".,false", "가,false"})
    void validateNumber(String number, boolean expected) {
        //when
        boolean actual = ExpressionValidator.validNumber(number);

        //then
        assertEquals(expected, actual);
    }

    @DisplayName("사용자 정의 구분자가 포함되어 있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"//?\\n1?2?3,true", "1:2;3,false"})
    void isCustomDelimiterExist(String value, boolean expected) {
        //given
        String expressionValue = TestInputUtils.replaceLinefeed(value);

        //when
        boolean actual = ExpressionValidator.isCustomDelimiterExist(expressionValue);

        //then
        assertEquals(expected, actual);
    }
}
