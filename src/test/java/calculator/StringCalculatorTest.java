package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @DisplayName("배열을 연산한다")
    @Test
    void calculate() {
        String[] tokens = {"1", "+", "2", "+", "3"};
        assertThat(StringCalculator.calculate(tokens)).isEqualTo(6);
    }

    @DisplayName("순서대로 연산한다")
    @Test
    void multipleOperations() {
        String[] tokens = {"2", "+", "3", "*", "4"};
        assertThat(StringCalculator.calculate(tokens)).isEqualTo(20);
    }

    @DisplayName("음수를 연산한다")
    @Test
    void negativeNumbers() {
        String[] tokens = {"-5", "+", "3"};
        assertThat(StringCalculator.calculate(tokens)).isEqualTo(-2);
    }

    @DisplayName("유효하지 않은 연산자를 사용하면 예외가 발생한다")
    @Test
    void invalidOperator() {
        String[] tokens = {"2", "^", "3"};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(tokens))
                .withMessageContaining("연산 불가");
    }
}
