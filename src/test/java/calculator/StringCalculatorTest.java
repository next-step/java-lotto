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
}
