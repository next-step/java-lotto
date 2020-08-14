import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionValidatorTest {
    @DisplayName("문자열 덧셈식 검사")
    @ParameterizedTest
    @CsvSource(value = {"1:2;3,true", "//?\n1?2?3,true", "1::2;3,false", "\\n1?2?3,false", " ,false"}, delimiter = ',')
    void validateExpression(String expressionValue, boolean expected) {
        //when
        boolean actual = ExpressionValidator.validExpression(expressionValue);
        // then
        assertEquals(expected, actual);
    }

    @DisplayName("문자열 덧셈식 검사 - 정상적인 문자열 덧셈식")
    @ParameterizedTest
    @ValueSource(strings = {"1:2;3", "//?\n1?2?3"})
    void validateNormalExpression(String expressionValue) {
        //when
        boolean actual = ExpressionValidator.validExpression(expressionValue);
        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("문자열 덧셈식 검사 - 잘못된 문자열 덧셈식")
    @ParameterizedTest
    @ValueSource(strings = {"1::2;3", "\\n1?2?3", " "})
    void validateWrongExpression(String expressionValue) {
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
}
