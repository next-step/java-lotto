package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @DisplayName("기본 구분자를 이용해 파싱할 수 있다")
    @ParameterizedTest
    @MethodSource("source_parse_validParameters_shouldSucceed")
    public void parse_defaultDelimiter_shouldSucceed(String input, PositiveNumber[] expected) {
        Parser parser = new Parser();
        assertThat(parser.parseToPositiveNumber(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_parse_validParameters_shouldSucceed() {
        return Stream.of(
                Arguments.of("0", new PositiveNumber[]{PositiveNumber.of("0")}),
                Arguments.of("1,2", new PositiveNumber[]{PositiveNumber.of("1"), PositiveNumber.of("2")}),
                Arguments.of("1,2,3", new PositiveNumber[]{PositiveNumber.of("1"), PositiveNumber.of("2"), PositiveNumber.of("3")}),
                Arguments.of("1,2:3", new PositiveNumber[]{PositiveNumber.of("1"), PositiveNumber.of("2"), PositiveNumber.of("3")}));
    }

    @DisplayName("커스텀 구분자를 이용해 파싱할 수 있다")
    @ParameterizedTest
    @MethodSource("source_parse_customDelimiter_shouldSucceed")
    public void parse_customDelimiter_shouldSucceed(String input, PositiveNumber[] expected) {
        Parser parser = new Parser();
        assertThat(parser.parseToPositiveNumber(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> source_parse_customDelimiter_shouldSucceed() {
        return Stream.of(
                Arguments.of("//!\n1!2!3", new PositiveNumber[]{PositiveNumber.of("1"), PositiveNumber.of("2"), PositiveNumber.of("3")}),
                Arguments.of("//@\n1@2@3", new PositiveNumber[]{PositiveNumber.of("1"), PositiveNumber.of("2"), PositiveNumber.of("3")}),
                Arguments.of("//pp\n1pp2pp3", new PositiveNumber[]{PositiveNumber.of("1"), PositiveNumber.of("2"), PositiveNumber.of("3")}),
                Arguments.of("//;\n1;2;3", new PositiveNumber[]{PositiveNumber.of("1"), PositiveNumber.of("2"), PositiveNumber.of("3")}));
    }
}
