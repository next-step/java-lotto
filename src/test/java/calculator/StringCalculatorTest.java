 package calculator;

import calculator.type.Add;
import calculator.type.Divide;
import calculator.type.Multiply;
import calculator.type.Subtract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    @Test
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void calculate() {
        int result = calculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }

    @Test
    void add() {
        int result = new Add().operate(10, 20);

        assertThat(result).isEqualTo(30);
    }

    @Test
    void subtract() {
        int result = new Subtract().operate(20, 10);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void multiply() {
        int result = new Multiply().operate(10, 20);

        assertThat(result).isEqualTo(200);
    }

    @Test
    void divide() {
        int result = new Divide().operate(20, 5);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("0으로 나누면 예외 발생")
    @Test
    void divideZero() {
        assertThatThrownBy(() -> new Divide().operate(10, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지원하지 않는 연산자 입력 시 예외 발생")
    @Test
    void calculateWhenInputNotSupportedOperator() {
        assertThatThrownBy(() -> calculator.calculate("2 % 3")).isInstanceOf(IllegalArgumentException.class);
    }
}
