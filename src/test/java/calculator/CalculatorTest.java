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
}
