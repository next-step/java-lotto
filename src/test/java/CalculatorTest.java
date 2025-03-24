import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("하나의 숫자로 이루어진 표현식을 계산할 수 있다.")
    void singleNumberTest() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("5");
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    @DisplayName("두 개의 숫자로 이루어진 덧셈을 할 수 있다.")
    void additionTest() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("2 + 3");
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }

    @Test
    @DisplayName("두 개의 숫자로 이루어진 뺼셈을 할 수 있다.")
    void subtractionTest() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("5 - 3");
        assertThat(calculator.calculate(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("두 개의 숫자로 이루어진 곱셈을 할 수 있다.")
    void multiplicationTest() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("2 * 3");
        assertThat(calculator.calculate(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("두 개의 숫자로 이루어진 나눗셈을 할 수 있다.")
    void divisionTest() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("6 / 3");
        assertThat(calculator.calculate(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("둘 이상의 연산으로 이루어진 표현식을 계산할 수 있다.")
    void multipleOperationsTest() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("2 + 3 * 4 / 2");
        assertThat(calculator.calculate(input)).isEqualTo(10);
    }

    @Test
    @DisplayName("0으로 나누기를 시도하면 예외가 발생한다.")
    void shouldThrowExceptionWhenDividingByZero() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("2 / 0");
        assertThatThrownBy(() -> calculator.calculate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로 나눌 수 없습니다.");
    }

}
