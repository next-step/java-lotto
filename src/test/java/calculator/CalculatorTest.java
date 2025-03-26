package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("사칙 연산을 수행한다.")
    @Nested
    class calculate {

        @DisplayName("덧셈을 수행할 수 있다.")
        @Test
        void add() {
            String text = "1 + 3";
            assertThat(calculator.calculate(text)).isEqualTo(4);
        }

        @DisplayName("뺄셈을 수행할 수 있다.")
        @Test
        void subtract() {
            String text = "3 - 1";
            assertThat(calculator.calculate(text)).isEqualTo(2);
        }

        @DisplayName("곱셈을 수행할 수 있다.")
        @Test
        void multiplyBy() {
            String text = "2 * 4";
            assertThat(calculator.calculate(text)).isEqualTo(8);
        }

        @DisplayName("나눗셈을 수행할 수 있다.")
        @Test
        void divideBy() {
            String text = "8 / 2";
            assertThat(calculator.calculate(text)).isEqualTo(4);
        }

        @DisplayName("여러 연산자가 섞인 사칙연산을 수행할 수 있다.")
        @Test
        void multipleCalculate() {
            String text = "1 + 2 * 3 - 1 / 2";
            assertThat(calculator.calculate(text)).isEqualTo(4);
        }
    }
}
