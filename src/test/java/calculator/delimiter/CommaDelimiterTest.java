package calculator.delimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CommaDelimiterTest {
    private Delimiter delimiter;

    @BeforeEach
    void setup() {
        delimiter = new CommaDelimiter();
    }

    @ParameterizedTest
    @MethodSource("provideCommaString")
    @DisplayName(", 구분자 테스트")
    void commaDelimiterTest(List<String> expression, List<String> result) {
        List<String> splitExpression = delimiter.split(expression);
        assertThat(splitExpression).isEqualTo(result);
    }

    private static Stream<Arguments> provideCommaString() {
        return Stream.of(
                Arguments.of(Arrays.asList("1,2,3"), Arrays.asList("1","2","3")),
                Arguments.of(Arrays.asList("1"), Arrays.asList("1"))
        );
    }
}