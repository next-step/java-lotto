package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringExpressionTest {

    @DisplayName("문자열 스플릿 기능 확인")
    @ParameterizedTest
    @MethodSource("provideString")
    void splitTest(String source, String[] result) {

        StringExpression expression = StringExpression.of(source);
        List<String> numbers = expression.split();

        assertThat(numbers).containsExactlyInAnyOrder(result);
    }

    private static Stream<Arguments> provideString() {
        return Stream.of(
                Arguments.of("1", new String[] {"1"}),
                Arguments.of("3,5:8", new String[] {"3", "5", "8"})
        );
    }

    @DisplayName("커스텀 구분자 문자열 스플릿 기능 확인")
    @ParameterizedTest
    @MethodSource("provideCustomDelimiterString")
    void customStringSplitTest(String source, String[] result) {

        StringExpression expression = StringExpression.of(source);
        List<String> numbers = expression.split();

        assertThat(numbers).containsExactlyInAnyOrder(result);
    }

    private static Stream<Arguments> provideCustomDelimiterString() {
        return Stream.of(
                Arguments.of("//,\n1,2,3", new String[] {"1", "2", "3"}),
                Arguments.of("//!\n1!2!3", new String[] {"2", "1", "3"})
        );
    }
}
