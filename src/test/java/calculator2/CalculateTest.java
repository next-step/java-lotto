package calculator2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculateTest {
    @ParameterizedTest
    @DisplayName("정상적인 입력")
    @ValueSource(strings = {"1 + 2 * 3 / 4"})
    public void calculate(String expression) {
        Assertions.assertThat(Calculate.calculate(expression)).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("잘못된 입력")
    @ValueSource(strings = {"1+2", "1 @ 2", "1 / 0", "1", "@", "+"})
    public void calculate(String expression) {
        Assertions.assertThat(Calculate.calculate(expression)).isEqualTo(IllegalArgumentException.class);
    }
}
