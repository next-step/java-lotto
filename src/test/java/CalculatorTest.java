import domain.Calculator;
import domain.Tokens;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    @Test
    @DisplayName("덧셈 연산을 수행 확인")
    void calculate_addition() {
        testCalculation("2 + 3", 5);
    }

    @Test
    @DisplayName("뺄셈 연산을 수행 확인")
    void calculate_subtract() {
            testCalculation("5 - 3", 2);
        }

    @Test
    @DisplayName("곱하기 연산을 수행 확인")
    void calculate_multiply() {
        testCalculation("2 * 3", 6);
    }

    @Test
    @DisplayName("나누기 연산을 수행 확인")
    void calculate_division() {
        testCalculation("7 / 3", 2);
    }

    @Test
    @DisplayName("나누기 연산 수행할 때 0으로 나누는 경우 예외를 던진다.")
    void calculate_division_byZero() {
        assertThrows(IllegalArgumentException.class, () -> new Calculator(new Tokens("7 / 0")).calculate());
    }

    private void testCalculation(String expression, int expected) {
        Tokens tokens = new Tokens(expression);
        Calculator calculator = new Calculator(tokens);

        int result = calculator.calculate();

        assertThat(result).isEqualTo(expected);
    }
}
