package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OperatorTest {

        @Test
        void 더하기() {
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
}
