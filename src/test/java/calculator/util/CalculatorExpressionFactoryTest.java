package calculator.util;

import calculator.dto.CalculatorExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CalculatorExpressionFactory 테스트")
class CalculatorExpressionFactoryTest {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    @ParameterizedTest
    @MethodSource("provideSourceToOf")
    @DisplayName("CalculatorExpressionFactory of, 정상 케이스 테스트")
    void of_정상(String expression, String expectedSeparator, String expectedFormula) {
        // When
        CalculatorExpression calculatorExpression = CalculatorExpressionFactory.of(expression, pattern);

        // Then
        assertEquals(expectedSeparator, calculatorExpression.getSeparator());
        assertEquals(expectedFormula, calculatorExpression.getFormula());
    }

    static Stream<Arguments> provideSourceToOf() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", ",|:|;", "1;2;3"),
                Arguments.of("//@\n4;5;6", ",|:|@", "4;5;6"),
                Arguments.of("1;2;3", ",|:", "1;2;3")
        );
    }
}