package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈을 할때 1과 2을 넣으면 3을 반환한다.")
    void add() {
        assertThat(Calculator.sum(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("마이너스 할때 1과 2값을 넣으면 -1을 반환한다.")
    void minus() {
        assertThat(Calculator.minus(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈을 할때 1과 2값을 넣으면 2를 반환한다.")
    void multiply() {
        assertThat(Calculator.multiply(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈을 할때 4와 2 값을 넣으면 2를 반환한다.")
    void divide() {
        assertThat(Calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈을 할때 정수로 나눠지지 않을 경우 IllegalArgumentException 을 반환한다.")
    void divideNotInt() {
        Assertions.assertThatThrownBy(() -> Calculator.divide(3, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("나눗셈을 할때 0으로 나눌 경우 IllegalArgumentException 을 반환한다.")
    void divideZero() {
        Assertions.assertThatThrownBy(() -> Calculator.divide(3, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
