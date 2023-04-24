package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void plus_test() {
        int result = Calculator.plus(1, 2);

        assertThat(result).isEqualTo(3);
    }
}
