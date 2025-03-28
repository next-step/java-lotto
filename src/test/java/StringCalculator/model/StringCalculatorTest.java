package StringCalculator.model;

import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private static StringCalculator calculator = new StringCalculator();

    @Test
    void inputIsNull(){
        assertThatIllegalArgumentException()
                .isThrownBy(()->calculator.calculate(null))
                .withMessage("input is null");
    }

    @Test
    void inputIsBlank(){
        assertThatIllegalArgumentException()
                .isThrownBy(()->calculator.calculate("  "))
                .withMessage("input is blank");
    }

    @Test
    void notArithmeticSign(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->calculator.calculate("2 + 3 # 7"))
                .withMessage("There is non-arithmetic sign");
    }

    @Test
    void divideByZero(){
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(()->calculator.calculate("2 / 0"))
                .withMessage("divided by zero");
    }

    @Test
    void calculateExactly(){
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
