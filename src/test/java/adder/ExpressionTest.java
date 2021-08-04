package adder;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ExpressionTest {

    @Test
    @DisplayName("입력값이 null 인 경우")
    public void nullInput() {
        // given
        String input = null;
        Expression expectedExpression = new Expression("0");

        // when
        Expression expression = new Expression(input);

        // then
        assertThat(expression).isEqualTo(expectedExpression);
    }

    @Test
    @DisplayName("입력값이 공백 인 경우")
    public void blankInput() {
        // given
        String input = "";
        Expression expectedExpression = new Expression("0");

        // when
        Expression expression = new Expression(input);

        // then
        assertThat(expression).isEqualTo(expectedExpression);
    }

    @ParameterizedTest(name = "Expression 생성 | {arguments}")
    @CsvSource(value = {"1,2:3|1,2:3", "//;\\n1;2;3|//;\\n1;2;3"}, delimiter = '|')
    public void createExpression(String input, String expected) {
        // given
        Expression expectedExpression = new Expression(expected);

        // when
        Expression expression = new Expression(input);

        // then
        assertThat(expression).isEqualTo(expectedExpression);
    }

    @Test
    @DisplayName("split null 입력")
    public void splitNullInput() {
        // given
        Expression expression = new Expression("1,2:3:4");
        String delimiterPattern = null;
        String message = Expression.NON_NULL;

        // when
        ThrowingCallable throwingCallable = () -> expression.split(delimiterPattern);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "split 테스트 | {arguments}")
    @CsvSource(value = {"1,2:3:4&,|:&4", "1,2:3:4,5&,|:&5"}, delimiter = '&')
    public void split(String input, String delimiterPattern, int expectedSize) {
        // given
        Expression expression = new Expression(input);

        // when
        List<String> numbers = expression.split(delimiterPattern);

        // then
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("getMatchers null 입력")
    public void getMatchersNullInput() {
        // given
        Expression expression = new Expression("1,2:3:4");
        Pattern pattern = null;
        String message = Expression.NON_NULL;

        // when
        ThrowingCallable throwingCallable = () -> expression.getMatchers(pattern);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getMatchers 테스트")
    public void getMatchers() {
        // given
        Expression expression = new Expression("//;\n1;2;3");
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        boolean findExpected = true;
        String expectedGroup1 = ";";
        String expectedGroup2 = "1;2;3";

        // when
        Matcher matchers = expression.getMatchers(pattern);


        // then
        assertThat(matchers.find()).isEqualTo(findExpected);
        assertThat(matchers.group(1)).isEqualTo(expectedGroup1);
        assertThat(matchers.group(2)).isEqualTo(expectedGroup2);
    }
}