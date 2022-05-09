package Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    private static Stream<Arguments> calculatorTestArgs() {
        return Stream.of(
                arguments("10 + 20", 30),
                arguments("30 - 20", 10),
                arguments("20 - 30", -10),
                arguments("10 * 20", 200),
                arguments("20 / 10", 2),
                arguments("10 / 20", 0),
                arguments("20 + 10 - 20 * 5", 50),
                arguments("1 / 5 + 10 / 1", 10),
                arguments("1 * 10 - 5 / 1", 5),
                arguments("1 / 5 / 5 / 1", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("calculatorTestArgs")
    public void calcTest(String expression, int result) {
        assertThat(Calculator.executeCalc(expression)).isEqualTo(result);
    }
}
