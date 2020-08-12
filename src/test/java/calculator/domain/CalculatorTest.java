package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static Stream<Arguments> makeCalculatorNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList("3", "5", "11"), 19),
                Arguments.of(Arrays.asList("0", "7"), 7),
                Arguments.of(Arrays.asList("1", "1", "1", "1", "1"), 5),
                Arguments.of(Arrays.asList("3"), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("makeCalculatorNumbers")
    void add(List<String> inputNumbers, int expectedResult) {
        Calculator calculator = new Calculator();
        Numbers numbers = Numbers.create(inputNumbers);

        int calculatorResult = calculator.add(numbers);

        assertThat(calculatorResult).isEqualTo(expectedResult);
    }
}
