package calculator.domain;

import calculator.util.CalculatorNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CalculatorNumbers 테스트")
class CalculatorNumbersTest {

    @ParameterizedTest
    @MethodSource("provideSourceToSum")
    void sum_정상(String[] input, int expectedResult) {
        // When
        CalculatorNumbers calculatorNumbers = CalculatorNumbersFactory.from(input);
        int actualResult = calculatorNumbers.sum();

        // Then
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> provideSourceToSum() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3"}, 6),
                Arguments.of(new String[]{"4", "2", "1"}, 7),
                Arguments.of(new String[]{"1", "5", "8", "9", "11"}, 34)
        );
    }
}