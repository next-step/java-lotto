package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExpressionParserTest {

    private final Delimiters delimiters = new Delimiters("");

    @DisplayName("ExpressionParser 객체 생성")
    @Test
    void ExpressionParser_객체_생성() {

        // then
        assertDoesNotThrow(() -> new ExpressionParser(delimiters));
    }

    @DisplayName("parse 테스트 - 커스텀 구분자")
    @Test
    void parse_테스트_커스텀_구분자() {
        // given
        final String input = "1;2;3";
        final Delimiters delimiters = new Delimiters(";");
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // when
        final List<Integer> numbers = expressionParser.parse(input);

        // then
        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("parse 테스트 - default 구분자")
    @Test
    void parse_테스트_기본_구분자() {
        // given
        final String input = "1,2:3";
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // when
        final List<Integer> numbers = expressionParser.parse(input);

        // then
        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("구분자가 아닌 문자가 들어오면 예외를 발생시킨다")
    @ValueSource(strings = {"1,-2:3", "1_2:3", "1,a,3"})
    @ParameterizedTest
    void validateContainsCharacter(final String input) {
        // given
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> expressionParser.parse(input));
    }

    @DisplayName("2개 이상의 연속된 구분자가 들어오면 예외를 발생시킨다")
    @ValueSource(strings = {"1::2:3", "1,,2,3", "1::2,3", "1,,2:3"})
    @ParameterizedTest
    void getExpression_연속된_구분자(final String input) {
        // given
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // then
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> expressionParser.parse(input));
    }
}
