package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class StringAdditionExpressionTest {
    @DisplayName("기본 구분자 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3"})
    void testConstructor_withDefaultSeparator(String input) {
        StringAdditionExpression expression = new StringAdditionExpression(input);
        Assertions.assertThat(expression)
                .hasFieldOrPropertyWithValue("input", input)
                .hasFieldOrPropertyWithValue("separator", StringAdditionExpression.DEFAULT);
    }

    @DisplayName("커스텀 구분자 테스트")
    @ParameterizedTest
    @MethodSource("providerTestConstructor_withCustomSeparator")
    void testConstructor_withCustomSeparator(String input, String separator) {
        StringAdditionExpression expression = new StringAdditionExpression(input);
        Assertions.assertThat(expression)
                .hasFieldOrPropertyWithValue("input", input)
                .hasFieldOrPropertyWithValue("separator", separator);
    }

    static Stream<Arguments> providerTestConstructor_withCustomSeparator() {
        return Stream.of(
                Arguments.of("//!\n1!2!3", "!"),
                Arguments.of("//n\n1n2n3", "n")
        );
    }

}
