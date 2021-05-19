package calculator.util;

import calculator.domain.CalculatorNumber;
import calculator.domain.CalculatorNumbers;
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

@DisplayName("CalculatorNumbersFactoryTest 테스트")
class CalculatorNumbersFactoryTest {

    @ParameterizedTest
    @MethodSource("provideSourceToFrom")
    @DisplayName("CalculatorNumbersFactory from, 정상 케이스 테스트")
    void from_정상(String[] input, CalculatorNumbers expectedResult) {
        // When
        CalculatorNumbers actualResult = CalculatorNumbersFactory.from(input);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> provideSourceToFrom() {
        List<Arguments> result = new ArrayList<>();
        String[][] allInputs = {{"1", "2", "3"}, {"4", "1", "2"}, {"1", "5", "4", "3", "7"}};
        List<CalculatorNumbers> expectedResults = getExpectedResultsOfForm(allInputs);

        for (int i = 0; i < allInputs.length; i++) {
            result.add(Arguments.of(allInputs[i], expectedResults.get(i)));
        }
        return result.stream();
    }

    private static List<CalculatorNumbers> getExpectedResultsOfForm(String[][] allInputs) {
        return Arrays.stream(allInputs).sequential()
                .map(eachInput -> Arrays.stream(eachInput)
                        .map(CalculatorNumber::new)
                        .collect(Collectors.toList()))
                .map(CalculatorNumbers::new)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("CalculatorNumbersFactory from, 런타임 예외 케이스 테스트")
    void from_예외() {
        // Given
        String[] input = {"1", "-1", "4"};

        // When, Then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> CalculatorNumbersFactory.from(input));
    }
}