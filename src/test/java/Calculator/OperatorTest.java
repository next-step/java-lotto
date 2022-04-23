package Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OperatorTest {

    private static Stream<Arguments> operatorTestArgs() {
        return Stream.of(
                arguments(new String[] {"10", "+", "20"}, 30),
                arguments(new String[] {"30", "-", "20"}, 10),
                arguments(new String[] {"20", "-", "30"}, -10),
                arguments(new String[] {"10", "*", "20"}, 200),
                arguments(new String[] {"20", "/", "10"}, 2),
                arguments(new String[] {"10", "/", "20"}, 0),
                arguments(new String[] {"20", "+", "10", "-", "20", "*", "5"}, 50),
                arguments(new String[] {"1", "/", "5", "+", "10", "/", "1"}, 10),
                arguments(new String[] {"1", "*", "10", "-", "5", "/", "1"}, 5),
                arguments(new String[] {"1", "/", "5", "/", "5", "/", "1"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("operatorTestArgs")
    public void operatorTest(String[] expression, int result) {
        assertThat(Calculator.compute(expression)).isEqualTo(result);
    }
}
