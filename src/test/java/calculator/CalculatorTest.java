package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void testGetInstance() {
        Calculator calculator = Calculator.getInstance();
        Assertions.assertThat(calculator)
                .isEqualTo(Calculator.getInstance());
    }

    @Test
    void testToNumber() {
        String oneString = "1";
        int one = Calculator.getInstance()
                .toNumber(oneString);
        Assertions.assertThat(one)
                .isEqualTo(1);
    }

    @DisplayName("숫자 이외의 값을 입력할 경우 RuntimeException 을 던진다")
    @Test
    void testToNumber_whenNonNumericString() {
        String nonNumeric = "g";
        Assertions.assertThatThrownBy(
                () -> Calculator.getInstance()
                        .toNumber(nonNumeric))
                .isInstanceOf(RuntimeException.class);
    }


    @DisplayName("음수를 입력한 경우 RuntimeException 을 던진다")
    @Test
    void testAssurePositive_whenNegative() {
        int negative = -1;
        Assertions.assertThatThrownBy(
                () -> Calculator.getInstance()
                        .assurePositive(negative))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void testAssurePositive_whenPositive() {
        int positive = 1;
        Assertions.assertThatCode(() -> Calculator.getInstance()
                .assurePositive(positive))
                .doesNotThrowAnyException();
    }

}
