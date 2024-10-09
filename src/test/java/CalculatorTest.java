import domain.Calculator;
import domain.Tokens;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    @DisplayName("덧셈 연산을 수행 확인")
    void calculate_addition() {
        Tokens tokens = new Tokens("2 + 3");
        Calculator calculator = new Calculator(tokens);

        int result = calculator.calculate();

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 연산을 수행 확인")
    void calculate_subtract() {
        Tokens tokens = new Tokens("5 - 3");
        Calculator calculator = new Calculator(tokens);

        int result = calculator.calculate();

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기 연산을 수행 확인")
    void calculate_multiply() {
        Tokens tokens = new Tokens("2 * 3");
        Calculator calculator = new Calculator(tokens);

        int result = calculator.calculate();

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 연산을 수행 확인")
    void calculate_division() {
        Tokens tokens = new Tokens("7 / 3");
        Calculator calculator = new Calculator(tokens);

        int result = calculator.calculate();

        assertThat(result).isEqualTo(2);
    }
}
