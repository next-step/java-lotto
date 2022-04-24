package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("1과 2를 덧셈하면 3을 반환한다.")
    void add() {
        assertThat(Calculator.sum(1,2)).isEqualTo(3);
    }
}
