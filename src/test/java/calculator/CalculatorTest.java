package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void 덧셈_한_번_테스트() {
        assertThat(Calculator.start("1 + 1")).isEqualTo(2);
    }

    @Test
    void 덧셈_여러번_테스트() {
        assertThat(Calculator.start("1 + 1 + 1 + 1")).isEqualTo(4);
    }

    @Test
    void 덧셈_곱셈_테스트() {
        assertThat(Calculator.start("1 + 2 * 3")).isEqualTo(9);
    }

    @Test
    void 덧셈_곱셈_나눗셈_뺄셈_복합_테스트() {
        assertThat(Calculator.start("1 + 2 * 3 - 3 / 3")).isEqualTo(2);

    }
}
