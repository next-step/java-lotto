package StringCalculator.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlusOperatorTest {

    @DisplayName("덧셈")
    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @CsvSource({"4,5,9", "3,2,5", "5,5,10"})
    void plus(int a, int b, int c) {
        PlusOperator plusOperator = new PlusOperator();
        int result = plusOperator.calculate(new Operand(a), new Operand(b));
        assertEquals(c, result);
    }
}
