package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void 더하기_기능() {
        Calculator calculator = new Calculator();
        int result = calculator.plus(1,1);
        assertEquals(2, result);
    }

    @Test
    void 빼기_기능() {
        Calculator calculator = new Calculator();
        int result = calculator.minus(1, 1);
        assertEquals(0, result);
    }

    @Test
    void 곱하기_기능() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(3,4);
        assertEquals(12, result);
    }

    @Test
    void 나누기_기능() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(4, 2);
        assertEquals(2, result);
    }

}
