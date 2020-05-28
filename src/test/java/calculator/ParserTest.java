package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {

    @DisplayName("기본 구분자를 이용해 파싱할 수 있다")
    @ParameterizedTest
    @MethodSource("source_parse_validParameters_shouldSucceed")
    public void parse_defaultDelimiter_shouldSucceed(String input, int[] expected) {
        Parser parser = new Parser();
        assertThat(parser.parseToIntArray(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_parse_validParameters_shouldSucceed() {
        return Stream.of(
                Arguments.of("0", new int[]{0}),
                Arguments.of("1,2", new int[]{1, 2}),
                Arguments.of("1,2,3", new int[]{1, 2, 3}),
                Arguments.of("1,2:3", new int[]{1, 2, 3}));
    }

    @DisplayName("커스텀 구분자를 이용해 파싱할 수 있다")
    @ParameterizedTest
    @MethodSource("source_parse_customDelimiter_shouldSucceed")
    public void parse_customDelimiter_shouldSucceed(String input, int[] expected) {
        Parser parser = new Parser();
        assertThat(parser.parseToIntArray(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_parse_customDelimiter_shouldSucceed() {
        return Stream.of(
                Arguments.of("//!\n1!2!3", new int[]{1, 2, 3}),
                Arguments.of("//@\n1@2@3", new int[]{1, 2, 3}),
                Arguments.of("//pp\n1pp2pp3", new int[]{1, 2, 3}),
                Arguments.of("//;\n1;2;3", new int[]{1, 2, 3}));
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 throw RuntimeException")
    @ParameterizedTest
    @MethodSource("source_parse_invalidNumber_shouldFail")
    public void parse_invalidNumber_shouldFail(String input) {
        Parser parser = new Parser();
        assertThatThrownBy(() -> {
            parser.parseToIntArray(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    private static Stream<Arguments> source_parse_invalidNumber_shouldFail() {
        return Stream.of(
                Arguments.of("-1;2,3"),
                Arguments.of("//!\n-1!2!~"),
                Arguments.of("a;b;3"),
                Arguments.of("//;\n1;b;3"));
    }
}
