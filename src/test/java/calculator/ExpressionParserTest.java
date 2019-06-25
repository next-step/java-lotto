package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionParserTest {

    @DisplayName("콜론을 구분자가 포함된 표현식 파싱")
    @ParameterizedTest
    @MethodSource("provideParseWithColonResource")
    void parseWithColon(String expression, int expectSize) {

        NumberElementCollection elements = ExpressionParser.parse(expression);

        assertThat(elements.size()).isEqualTo(expectSize);
    }

    private static Stream<Arguments> provideParseWithColonResource() {
        return Stream.of(
                Arguments.of("1:2", 2),
                Arguments.of("1:2:3", 3)
        );
    }

    @DisplayName("콜론으로 시작하거나 종료하는 표현식")
    @ParameterizedTest
    @MethodSource("provideParseWithColonStartOrEnd")
    void parseWithColonStartOrEnd(String expression, int expectSize) {

        NumberElementCollection elements = ExpressionParser.parse(expression);

        assertThat(elements.size()).isEqualTo(expectSize);
    }

    private static Stream<Arguments> provideParseWithColonStartOrEnd() {
        return Stream.of(
                Arguments.of(":2", 1),
                Arguments.of("1:2:", 2)
        );
    }
}
