package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTests {
    @DisplayName("숫자 콜렉션을 입력 받아서 전체 합산을 진행한다.")
    @ParameterizedTest
    @MethodSource("numberCollections")
    void sumTest(List<Number> numbers, Number expected) {
        int result = Calculator.sum(numbers);
        assertThat(expected.getValue()).isEqualTo(result);
    }
    public static Stream<Arguments> numberCollections() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Number("1"), new Number("2"),
                        new Number("3"), new Number("4"), new Number("5")),
                        new Number("15")),
                Arguments.of(Arrays.asList(new Number("1"), new Number("2"),
                        new Number("3"), new Number("4")),
                        new Number("10")),
                Arguments.of(Arrays.asList(new Number("1"), new Number("2"),
                        new Number("3")),
                        new Number("6"))
        );
    }
}
