package step01;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TokenizerTest {

    private static Stream<Arguments> provideDefaultDelimiterResult() {
        return Stream.of(
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of("1:2:3", new String[]{"1", "2", "3"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideDefaultDelimiterResult")
    public void test_execute(String text, String[] expect) {
        assertThat(Tokenizer.execute(text)).isEqualTo(expect);
        assertThat(Tokenizer.execute(text)).isEqualTo(expect);
    }

    private static Stream<Arguments> provideMatcherResult() {
        return Stream.of(
                Arguments.of("//,\n1,2,3", "//(.)\n(.*)", new String[]{"1", "2", "3"}),
                Arguments.of("//;\n1;2;3", "//(.)\n(.*)", new String[]{"1", "2", "3"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideMatcherResult")
    public void test_execute_byMatcher(String text, String pattern, String[] expect) {
        assertThat(Tokenizer.executeByPattern(text, pattern)).isEqualTo(expect);
    }
}
