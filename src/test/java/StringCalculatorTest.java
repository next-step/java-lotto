import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("두 문자열을 더한다")
    void plus_test(){

        StringCalculator calculator
                = new StringCalculator();

        assertThat(calculator.calculate("2 + 3"))
                .isEqualTo(5);
    }

    @Test
    @DisplayName("두 문자열을 뺀다")
    void minus_test(){
        StringCalculator calculator
                = new StringCalculator();

        assertThat(calculator.calculate("2 - 3"))
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("두 문자열을 곱한다")
    void multiple_test(){
        StringCalculator calculator
                = new StringCalculator();

        assertThat(calculator.calculate("2 * 3"))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("두 문자열을 나눈다")
    void divide_test(){
        StringCalculator calculator
                = new StringCalculator();

        assertThat(calculator.calculate("4 / 2"))
                .isEqualTo(2);
    }
}
