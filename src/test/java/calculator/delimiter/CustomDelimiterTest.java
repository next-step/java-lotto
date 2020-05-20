package calculator.delimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterTest {
    private Delimiter delimiter;

    @BeforeEach
    void setup() {
        delimiter = new CustomDelimiter();
    }

    @ParameterizedTest
    @MethodSource("provideCustomDelimiterExpressions")
    @DisplayName("커스텀 구분자 테스트")
    void customDelimiterSplitTest(List<String> expressions, List<String> results) {
        List<String> splitExpressions = delimiter.split(expressions);
        assertThat(splitExpressions).isEqualTo(results);
    }

    private static Stream<Arguments> provideCustomDelimiterExpressions() {
        return Stream.of(
                Arguments.of(Arrays.asList("//;\n1;2;3"), Arrays.asList("1", "2", "3")),
                Arguments.of(Arrays.asList("//v\n1v2v4"), Arrays.asList("1", "2", "4"))
        );
    }
}
