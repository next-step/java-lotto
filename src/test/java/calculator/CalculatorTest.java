package calculator;

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
}
