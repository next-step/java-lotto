package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {

    @ParameterizedTest
    @MethodSource("additionTestData")
    @DisplayName("덧셈 테스트")
    void additionTest(String expression, int expected) {
        var result = Calculator.calculate(expression);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> additionTestData() {
        return Stream.of(
                Arguments.of("2 + 3", 5),
                Arguments.of("2 + 4", 6),
                Arguments.of("2 + 5", 7)
        );
    }
}
