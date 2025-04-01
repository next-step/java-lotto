package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void testAdd() {
        int result = StringCalculator.calculate("1 + 2 + 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testSubtract() {
        int result = StringCalculator.calculate("10 - 2 - 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void testMultiply() {
        int result = StringCalculator.calculate("2 * 3 * 4");
        assertThat(result).isEqualTo(24);
    }

    @Test
    public void testDivide() {
        int result = StringCalculator.calculate("10 / 2");
        assertThat(result).isEqualTo(5);
    }
}
