import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 공백_split() {
        assertThat(StringCalculator.splitString("2 + 3 * 4 / 2")).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    void 덧셈() {
        assertThat(StringCalculator.calculator(2, 3, "+")).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.calculator(5, 2, "-")).isEqualTo(3);
    }

    @Test
    void 곱셈() {
        assertThat(StringCalculator.calculator(2, 3, "*")).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(StringCalculator.calculator(6, 2, "/")).isEqualTo(3);
    }

    @Test
    void 복합_연산() {
        assertThat(StringCalculator.splitAndCalculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
