package StringCalculator.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideOperatorTest {

    @DisplayName("나눗셈")
    @ParameterizedTest(name="[{index}] {0} / {1} = {2}")
    @CsvSource({"20,4,5", "14,2,7", "32,4,8"})
    void divide(int a, int b , int c){
        DivideOperator divideOperator = new DivideOperator();
        int result = divideOperator.calculate(new Operand(a), new Operand(b));
        assertEquals(c, result);
    }

    @DisplayName("나눗셈 by zero")
    @ParameterizedTest(name="[{index}] {0} / {1} = error")
    @CsvSource({"20,0", "14,0", "32,0"})
    void divide_by_zero(int a, int b){
        DivideOperator divideOperator = new DivideOperator();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> divideOperator.calculate(new Operand(a), new Operand(b)));
    }
}
