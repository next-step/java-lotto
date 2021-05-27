package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CalculatorNumbers 테스트")
class CalculatorNumbersTest {

    @ParameterizedTest
    @MethodSource("provideSourceToSum")
    void sum_정상(String[] input, int expectedResult) {
        // When
        CalculatorNumbers calculatorNumbers = CalculatorNumbers.from(input);
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
    @ParameterizedTest
    @MethodSource("provideSourceToFrom")
    @DisplayName("CalculatorNumbers from, 정상 케이스 테스트")
    void from_정상(String[] input, CalculatorNumbers expectedResult) {
        // When
        CalculatorNumbers actualResult = CalculatorNumbers.from(input);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> provideSourceToFrom() {
        List<Arguments> result = new ArrayList<>();
        String[][] allInputs = {{"1", "2", "3"}, {"4", "1", "2"}, {"1", "5", "4", "3", "7"}};
        List<CalculatorNumbers> expectedResults = getExpectedResultsOfFrom(allInputs);

        for (int i = 0; i < allInputs.length; i++) {
            result.add(Arguments.of(allInputs[i], expectedResults.get(i)));
        }
        return result.stream();
    }

    private static List<CalculatorNumbers> getExpectedResultsOfFrom(String[][] allInputs) {
        return Arrays.stream(allInputs).sequential()
                .map(eachInput -> Arrays.stream(eachInput)
                        .map(CalculatorNumber::new)
                        .collect(Collectors.toList()))
                .map(CalculatorNumbers::new)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("CalculatorNumbers from, 런타임 예외 케이스 테스트")
    void from_예외() {
        // Given
        String[] input = {"1", "-1", "4"};

        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CalculatorNumbers.from(input));
    }
}