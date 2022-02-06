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

    @DisplayName("정상적인 매개변수로 객체를 생성할 때 예외가 발생하지 않는다.")
    @Test
    void When_객체_생성_Then_예외가_발생하지_않음() {
        // then
        assertDoesNotThrow(() -> new ExpressionParser(delimiters));
    }

    @DisplayName("커스텀 구분자로 식을 해석해 숫자 리스트를 반환한다.")
    @Test
    void Given_유효한_구분자_식_When_식_해석_Then_숫자_리스트_반환() {
        // given
        final String input = "1;2;3";
        final Delimiters delimiters = new Delimiters(";");
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // when
        final List<Integer> numbers = expressionParser.parse(input);

        // then
        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("기본 구분자로 이루어진 식을 입력받아 숫자 리스트를 반환한다.")
    @Test
    void Given_기본_구분자_식_When_식_해석_Then_숫자_리스트_반환() {
        // given
        final String input = "1,2:3";
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // when
        final List<Integer> numbers = expressionParser.parse(input);

        // then
        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("구분자가 아닌 문자가 들어오면 예외를 발생시킨다.")
    @ValueSource(strings = {"1,-2:3", "1_2:3", "1,a,3"})
    @ParameterizedTest
    void Given_구분자가_아닌_문자가_포함된_식_When_식_해석_Then_예외_발생(final String input) {
        // given
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> expressionParser.parse(input));
    }

    @DisplayName("2개 이상의 연속된 구분자가 들어오면 예외를 발생시킨다.")
    @ValueSource(strings = {"1::2:3", "1,,2,3", "1::2,3", "1,,2:3"})
    @ParameterizedTest
    void Given_2개_이상의_연속된_구분자가_포함된_식_When_식_해석_Then_예외_발생(final String input) {
        // given
        final ExpressionParser expressionParser = new ExpressionParser(delimiters);

        // then
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> expressionParser.parse(input));
    }
}
