package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 기능")
    void test1() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 기능")
    void test2() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(4, 2);

        assertThat(result).isEqualTo(2);
    }
}
