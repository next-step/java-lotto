package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

        @Test
        public void 더하기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Addition.add(valueX, valueY)).isEqualTo(11);
        }

        @Test
        public void 빼기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Subtraction.subtract(valueX, valueY)).isEqualTo(-9);
        }

        @Test
        public void 곱하기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Multiplication.multiple(valueX, valueY)).isEqualTo(10);
        }

        @Test
        public void 나누기() {
                int valueX = 1;
                int valueY = 10;
                assertThat(Division.divide(valueX, valueY)).isEqualTo(0);
        }
}
