package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.getSplit;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void split() {
        assertThat(getSplit("1 + 2")).containsExactly("1", "+", "2");
    }

}
