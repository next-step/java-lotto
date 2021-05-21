package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StringAddCalculatorTest 테스트")
class StringAddCalculatorTest {

    @ParameterizedTest
    @MethodSource("provideSourceToCalculate")
    @DisplayName("StringAddCalculatorTest calculate, 케이스_별_결과_검증")
    void calculate_케이스_별_결과_검증(String expression, int expectedResult) {
        // When
        int actualResult = StringAddCalculator.calculate(expression);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> provideSourceToCalculate() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(null, 0),
                Arguments.of("//;\n1,2;3:4", 10),
                Arguments.of("//@\n4@5@6:3", 18),
                Arguments.of("2:2:4", 8)
        );
    }

    @Test
    @DisplayName("StringAddCalculatorTest calculate, 런타임 예외")
    void calculate_예외() {
        // Given
        String expression = "-1:0,5";

        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringAddCalculator.calculate(expression));
    }
}