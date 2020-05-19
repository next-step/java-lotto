package calculator;

import calculator.delimiter.ColonDelimiter;
import calculator.delimiter.CommaDelimiter;
import calculator.delimiter.CustomDelimiter;
import calculator.delimiter.Delimiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    private List<Delimiter> delimiters;

    @BeforeEach
    void setup() {
        delimiters = Arrays.asList(
                new ColonDelimiter(),
                new CommaDelimiter(),
                new CustomDelimiter()
        );
    }

    @ParameterizedTest
    @MethodSource("provideExpressions")
    @DisplayName("계산식 분리 테스트")
    void expressionSplitTest(String expression, List<String> splitExpression) {
        List<String> result = Splitter.split(expression, delimiters);
        assertThat(result).isEqualTo(splitExpression);
    }

    private static Stream<Arguments> provideExpressions() {
        return Stream.of(
                Arguments.of("1:2:3", Arrays.asList("1", "2", "3")),
                Arguments.of("1,2,3", Arrays.asList("1", "2", "3")),
                Arguments.of("//;\n1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("//!\n1!2,3:4", Arrays.asList("1", "2", "3", "4"))
        );
    }
}
