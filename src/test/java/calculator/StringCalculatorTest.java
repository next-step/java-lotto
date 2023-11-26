package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.getSplit;
import static calculator.StringCalculator.plus;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void split() {
        assertThat(getSplit("1 + 2")).containsExactly("1", "+", "2");
    }

    @Test
    void 덧셈() {
        assertThat(plus("1 + 2")).isEqualTo(3);
    }



}
