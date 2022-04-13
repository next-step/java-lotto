package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void addition() {
        String source = "2 + 3";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtraction() {
        String source = "5 - 2";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplication() {
        String source = "5 * 2";

        int result = calculator.splitAndCalculate(source);

        assertThat(result).isEqualTo(10);
    }

}