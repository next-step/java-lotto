package edu.nextstep.camp.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternMatcherTest {
    static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    final static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    @ParameterizedTest(name ="not matched patterns: {arguments}")
    @ValueSource(strings = {"1,2", "//%/n1,2", "//\n1,2"})
    public void patternNotMatched(String input) {
        assertThat(pattern.matcher(input).find()).isFalse();
    }

    @ParameterizedTest(name ="matched patterns: {arguments}")
    @ValueSource(strings = {"//%\n1,2", "///\n1,2", "//1\n1", "//^\n"})
    public void patternMatched(String input) {
        assertThat(pattern.matcher(input).find()).isTrue();
    }

    static Stream<Arguments> extractArguments() {
        return Stream.of(
                Arguments.of("//%\n1,2", "%", "1,2"),
                Arguments.of("//1\n1", "1", "1")
        );
    }

    @ParameterizedTest(name ="extract patterns: {0} -> {1}")
    @MethodSource("extractArguments")
    public void extractMatched(String input, String expectedGroup1, String expectedGroup2) {
        final Matcher matcher = pattern.matcher(input);
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isEqualTo(expectedGroup1);
        assertThat(matcher.group(2)).isEqualTo(expectedGroup2);
    }

    @ParameterizedTest(name ="Number pattern matched: {arguments}")
    @ValueSource(strings = {"-1", "0", "1"})
    public void matchNumbers(String input) {
        assertThat(NUMBER_PATTERN.matcher(input).find()).isTrue();
    }

}
