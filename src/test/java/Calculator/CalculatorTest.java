package Calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    private static Stream<Arguments> operatorTestArgs() {
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
    @MethodSource("operatorTestArgs")
    public void operatorTest(String expression, int result) {
        assertThat(Calculator.executeCalc(expression)).isEqualTo(result);
    }

    @Test
    @DisplayName("계산기 통합 테스트")
    public void calcTest() {
        assertEquals(Calculator.executeCalc("1 + 2 + 3 + 4 + 5"), 15);
        assertEquals(Calculator.executeCalc("1 / 2 / 3 / 4 / 5"), 0);
        assertEquals(Calculator.executeCalc("1 * 100 - 100 + 100 / 100"), 1);
        assertEquals(Calculator.executeCalc("100 - 50 + 50 * 2"), 200);
    }

}
