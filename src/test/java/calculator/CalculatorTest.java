package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CalculatorTest {

        @Test
        void 더하기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Addition.add(valueX, valueY)).isEqualTo(11);
        }

        @Test
        void 빼기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Subtraction.subtract(valueX, valueY)).isEqualTo(-9);
        }

        @Test
        void 곱하기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Multiplication.multiple(valueX, valueY)).isEqualTo(10);
        }

        @Test
        void 나누기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Division.divide(valueX, valueY)).isEqualTo(0);
        }

        @Test
        void 입력_값이_null_또는_빈_공백이면_에러() {
                Calculator calculator = new Calculator();
                assertThatThrownBy(() -> calculator.calculate("")).isInstanceOf(IllegalArgumentException.class);
                assertThatThrownBy(() -> calculator.calculate(null)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 사칙연산_기호가_아니면_에러() {
                Calculator calculator = new Calculator();
                assertThatThrownBy(() -> calculator.calculate("1 @ 3")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 사칙연산_실행() {
                Calculator calculator = new Calculator();
                assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        }
}
