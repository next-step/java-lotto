package tutorial;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tutorial.StringCalculator.calculate;

class StringCalculatorTest {
    @Test
    void test() {
        assertThat(calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(calculate("2 + 6 * 7 / 5")).isEqualTo(11);
        assertThatThrownBy(() -> calculate("2 + 3 * 4 / 0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}