package StringCalculator.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyOperatorTest {

    @DisplayName("곱셈")
    @ParameterizedTest(name="[{index}] {0} * {1} = {2}")
    @CsvSource({"4,5,20", "3,2,6","5,5,25"})
    void plus(int a, int b , int c){
        MultiplyOperator multiplyOperator = new MultiplyOperator();
        int result = multiplyOperator.calculate(new Operand(a), new Operand(b));
        assertEquals(c, result);
    }
}
