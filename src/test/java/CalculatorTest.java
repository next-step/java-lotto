import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void splitTest() {
        var input = "2 + 3 * 4 / 2";

        var actual = calculator.split(input, Calculator.REGEX);
        var expect = new String[]{"2", "+", "3", "*", "4", "/", "2"};

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("validationTest_Arguments")
    void validationTest(String input, Exception exception) {
        assertThatThrownBy(() -> calculator.validation(input))
                .isInstanceOf(exception.getClass());
    }

    public static Stream<Arguments> validationTest_Arguments() {
        return Stream.of(
                Arguments.of(null, new IllegalArgumentException()),
                Arguments.of("", new IllegalArgumentException()),
                Arguments.of("A", new IllegalArgumentException()),
                Arguments.of("!", new IllegalArgumentException()),
                Arguments.of("아", new IllegalArgumentException())
        );
    }

    @ParameterizedTest
    @MethodSource("calculateTest_Arguments")
    void calculateTest(String input, double expect) {
        var actual = calculator.calculate(input);

        assertThat(actual).isEqualTo(expect);
    }

    public static Stream<Arguments> calculateTest_Arguments() {
        return Stream.of(
                Arguments.of("1 + 2", 3),
                Arguments.of("6 - 2", 4),
                Arguments.of("5 * 3", 15),
                Arguments.of("5 / 3", 1.6666666666666667),
                Arguments.of("10 / 3", 3.3333333333333335),
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("5 * 2 + 3 - 1 / 2", 6)
        );
    }
}
