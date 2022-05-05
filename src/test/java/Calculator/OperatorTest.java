package Calculator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OperatorTest {

    private static Stream<Arguments> operatorTestArgs() {
        return Stream.of(
                arguments(Operator.SUM.calc(10,5), 15),
                arguments(Operator.SUM.calc(10,15), 25),
                arguments(Operator.SUBTRACT.calc(100,50), 50),
                arguments(Operator.SUBTRACT.calc(10,5), 5),
                arguments(Operator.MULTIPLY.calc(10,5), 50),
                arguments(Operator.MULTIPLY.calc(100,5), 500),
                arguments(Operator.DIVIDE.calc(100,5), 20),
                arguments(Operator.DIVIDE.calc(100,10), 10)
        );
    }

    @ParameterizedTest
    @MethodSource("operatorTestArgs")
    public void operatorTest(int calcResult, int result) {
        Assertions.assertThat(calcResult).isEqualTo(result);
    }
}
