package edu.nextstep.camp.calc.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CommandParserTest {
    static Stream<Arguments> validArguments() {
        return Stream.of(
                Arguments.of(null, List.of(PositiveNumber.ZERO)),
                Arguments.of("", List.of(PositiveNumber.ZERO)),
                Arguments.of("1", List.of(PositiveNumber.of(1))),
                Arguments.of("1,2", List.of(PositiveNumber.of(1), PositiveNumber.of(2))),
                Arguments.of("1,2:3", List.of(PositiveNumber.of(1), PositiveNumber.of(2), PositiveNumber.of(3))),
                Arguments.of("//;\n1,2;3", List.of(PositiveNumber.of(1), PositiveNumber.of(2), PositiveNumber.of(3)))
        );
    }

    @ParameterizedTest(name = "parse: \"{0}\" -> {1}")
    @MethodSource("validArguments")
    public void parse(String input, Collection<PositiveNumber> expected) {
        assertThat(CommandParser.parse(input)).hasSameElementsAs(expected);
    }

    @ParameterizedTest(name = "parse failed: {arguments}")
    @ValueSource(strings = {"-1", "1,2,not-a-number", "1,2;3", "//;/n1,2;3", "/\n1,2", "//#\n1$2"})
    public void parseFailed(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CommandParser.parse(input))
                .withMessageContaining("invalid input");
    }

    static Stream<Arguments> validSplitWithDelimiterArguments() {
        return Stream.of(
                Arguments.of("1", List.of("1")),
                Arguments.of("1,2", List.of("1","2")),
                Arguments.of("1,2:3", List.of("1","2","3")),
                // invalid patterns but can be split
                Arguments.of("/\n1,2", List.of("/\n1", "2")),
                Arguments.of("//\n1,2", List.of("//\n1", "2")),
                Arguments.of("//#\n1$2", List.of("1$2")),
                Arguments.of("//;/n1,2;3", List.of("//;/n1", "2;3"))
        );
    }

    @ParameterizedTest(name = "split with delimiter: \"{0}\" -> {1}")
    @MethodSource("validSplitWithDelimiterArguments")
    public void splitWithDelimiter(String input, Collection<String> expected) {
        assertThat(CommandParser.split(input)).hasSameElementsAs(expected);
    }

    @Test
    @DisplayName("split with custom delimiter")
    public void splitWithCustomDelimiter() {
        assertThat(CommandParser.split("//;\n1,2;3")).hasSameElementsAs(List.of("1","2","3"));
    }
}
