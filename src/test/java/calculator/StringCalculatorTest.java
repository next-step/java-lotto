package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void shouldPlus(){
        Assertions.assertThat(StringCalculator.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    void shouldMinus(){
        Assertions.assertThat(StringCalculator.calculate("2 - 1")).isEqualTo(1);
    }

    @Test
    void shouldMultiply(){
        Assertions.assertThat(StringCalculator.calculate("2 * 1")).isEqualTo(2);
    }

    @Test
    void shouldDivide(){
        Assertions.assertThat(StringCalculator.calculate("2 / 1")).isEqualTo(2);
    }

    @Test
    void shouldCalculate(){
        Assertions.assertThat(StringCalculator.calculate("1 + 2 - 4 * 10 / 3")).isEqualTo(-3);
    }
}
