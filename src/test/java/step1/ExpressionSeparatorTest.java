package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionSeparatorTest {
    @ParameterizedTest
    @MethodSource("generateSampleForSplitMethodTesting")
    void split(final Expression input, final List<String> expected) {
        // when
        final List<String> result = ExpressionSeparator.split(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateSampleForSplitMethodTesting() {
        return Stream.of(
                Arguments.of(Expression.of("1,1"), Arrays.asList("1", "1")),
                Arguments.of(Expression.of("2:2"), Arrays.asList("2", "2")),
                Arguments.of(Expression.of("1,2:3"), Arrays.asList("1", "2", "3"))
        );
    }
}