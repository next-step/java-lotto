package Calculator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OperatorTest {

    // TODO

    private static Stream<Arguments> operatorTestArgs() {
        return Stream.of(
                arguments(Operator.SUM.calc(10,5), 15),
                arguments(Operator.SUM.calc(10,15), 25)
        );
    }

    @Test
    @MethodSource("operatorTestArgs")
    public void test(Method t, int result) {
        Assertions.assertThat(t).isEqualTo(result);
    }
}
