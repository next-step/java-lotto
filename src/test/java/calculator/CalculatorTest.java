package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CalculatorTest {

        @Test
        void 더하기() {
                Calculator calculator = new Calculator();
                int valueX = 1;
                int valueY = 10;
                assertThat(Operator.ADDITION.apply(valueX, valueY)).isEqualTo(11);
        }

        @Test
        void 빼기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Operator.SUBTRACTION.apply(valueX, valueY)).isEqualTo(-9);
        }

        @Test
        void 곱하기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Operator.MULTIPLICATION.apply(valueX, valueY)).isEqualTo(10);
        }

        @Test
        void 나누기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Operator.DIVISION.apply(valueX, valueY)).isEqualTo(0);
        }

        @ParameterizedTest
        @NullAndEmptySource
        void 입력_값이_null_또는_빈_공백이면_에러(String input) {
                Calculator calculator = new Calculator();
                assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
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
