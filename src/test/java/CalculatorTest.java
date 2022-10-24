import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("두 수를 더한 값을 반환한다.")
    public void add() {
        int actual = Calculator.run("1 + 2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("앞 수에서 뒷 수를 뺀 값을 반환한다.")
    public void subtract() {
        int actual = Calculator.run("2 - 1");

        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("두 수를 곱한 값을 반환한다.")
    public void multiply() {
        int actual = Calculator.run("2 * 3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("앞 수에서 뒷 수를 나눈 값을 반환한다.")
    public void divide() {
        int actual = Calculator.run("6 / 3");

        assertThat(actual).isEqualTo(2);
    }
}
