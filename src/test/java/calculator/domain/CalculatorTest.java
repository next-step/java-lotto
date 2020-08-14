package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    private static Stream<Arguments> makeCalculatorString() {
        return Stream.of(
                Arguments.of("3:5:11", 19),
                Arguments.of("5:0,7", 12),
                Arguments.of("//;\n1;1;1;1;1", 5),
                Arguments.of("3", 3)
        );
    }

    @DisplayName("add 테스트")
    @ParameterizedTest
    @MethodSource("makeCalculatorString")
    void add(String input, int expectedResult) {
        assertThat(calculator.add(input)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> makeCalculatorStringWithMetaCharacter() {
        return Stream.of(
                Arguments.of("//+\n3+5+11+1+6+13", 39),
                Arguments.of("//{\n5{0{7", 12),
                Arguments.of("//*\n1*1*1*1*1", 5),
                Arguments.of("//^\n9^9", 18),
                Arguments.of("//|\n9|9", 18)
        );
    }

    @DisplayName("add 테스트 - split Meta Character가 delimiters인 경우")
    @ParameterizedTest
    @MethodSource("makeCalculatorStringWithMetaCharacter")
    void add_with_meta_character(String input, int expectedResult) {
        assertThat(calculator.add(input)).isEqualTo(expectedResult);

    }

    @Test
    void meta_character_test() {
        // ^, *, $, +, {, }, (, ), [, ], ., ?
        String asterikaString = "1*1";
        Stream.of(asterikaString.split("\\*"))
                .forEach(System.out::println);
    }

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

//        int calculatorResult = calculator.add(numbers);

//        assertThat(calculatorResult).isEqualTo(expectedResult);
    }
}
