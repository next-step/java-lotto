package StringCalculator.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinusOperatorTest {

    @DisplayName("뺄셈")
    @ParameterizedTest(name="[{index}] {0} - {1} = {2}")
    @CsvSource({"5,3,2", "9,3,6", "4,1,3"})
    void plus(int a, int b , int c){
        MinusOperator minusOperator = new MinusOperator();
        int result = minusOperator.calculate(new Operand(a), new Operand(b));
        assertEquals(c, result);
    }
}
