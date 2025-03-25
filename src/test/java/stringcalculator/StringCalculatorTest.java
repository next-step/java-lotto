package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @DisplayName("덧셈 기능 테스트")
    @Test
    void add() {
        assertThat(StringCalculator.calculate("1 + 2 + -3")).isEqualTo(0);
    }

    @DisplayName("뺄셈 기능 테스트")
    @Test
    void minus() {
        assertThat(StringCalculator.calculate("10 - 2 - -3")).isEqualTo(11);
    }

    @DisplayName("곱셈 기능 테스트")
    @Test
    void multiply() {
        assertThat(StringCalculator.calculate("100 * 2 * -3")).isEqualTo(-600);
    }

    @DisplayName("나눗셈 기능 테스트")
    @Test
    void divide() {
        assertThat(StringCalculator.calculate("100 / 2 / -2")).isEqualTo(-25);
    }

    @DisplayName(" 모든 연산 포함하는 계산 기능 테스트")
    @Test
    void all_operator() {
        assertThat(StringCalculator.calculate("100 / 10 + 60 - 20 * 4")).isEqualTo(200);
    }
}
