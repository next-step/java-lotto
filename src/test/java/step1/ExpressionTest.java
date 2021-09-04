package step1;

import org.junit.jupiter.api.Test;
import step1.Expression;
import step1.Number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";

    @Test
    void basicDelimiterCreateTest() {
        String text = "1,2,3";
        final Expression actual = Expression.createExpression(text);
        final Expression expected = new Expression(BASIC_DELIMITER, text.split(BASIC_DELIMITER));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void customDelimiterCreateTest() throws RuntimeException {
        String text = "//;\n1;2;3";

        final Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if(matcher.find()) {
            final String customDelimiter = matcher.group(1);
            final String group = matcher.group(2);
            final String[] split = group.split(customDelimiter);
            final Expression actual = new Expression(customDelimiter, split);

            final Expression expected = Expression.createExpression(text);
            assertThat(actual).isEqualTo(expected);
            return;
        }
        throw new RuntimeException("표현식 매칭에 실패했습니다.");
    }

    @Test
    void oneNumberCreateTest() {
        final String text ="1";
        final Number actual = Expression.createExpression(text).add();
        final Number expected = new Number(1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void emptyStringTest() {
        final String text ="";
        final Number actual = Expression.createExpression(text).add();
        final Number expected = new Number(0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void nullTest() {
        final Number actual = Expression.createExpression(null).add();
        final Number expected = new Number(0);
        assertThat(actual).isEqualTo(expected);
    }
}