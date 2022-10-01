package Step1;

import Step1.CalculatorImpl;
import Step1.intefaces.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    public static Calculator calculator = new CalculatorImpl();

    @Test
    void 덧셈_테스트() {
        int num1 = 1;
        int num2 = 1;
        int result = 2;

        assertThat(calculator.addition(num1, num2)).isEqualTo(result);
    }

    @Test
    void 뺄셈_테스트() {
        int num1 = 10;
        int num2 = 5;
        int result = 5;

        assertThat(calculator.subtraction(num1, num2)).isEqualTo(result);
    }

    @Test
    void 곱셈_테스트() {
        int num1 = 10;
        int num2 = 2;
        int result = 20;

        assertThat(calculator.multiplication(num1, num2)).isEqualTo(result);
    }

    @Test
    void 나눗셈_테스트() {
        int num1 = 30;
        int num2 = 2;
        int result = 15;

        assertThat(calculator.division(num1, num2)).isEqualTo(result);
    }

}
