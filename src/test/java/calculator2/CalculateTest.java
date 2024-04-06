package calculator2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator2.domain.Calculate;

public class CalculateTest {
    @Test
    @DisplayName("정상적인 입력")
    public void calculate() {
        Assertions.assertThat(Calculate.calculate("1")).isEqualTo(1);
        Assertions.assertThat(Calculate.calculate("1 + 2 * 3 / 4")).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("잘못된 입력")
    @NullAndEmptySource
    @ValueSource(strings = {"1+2", "1 @ 2", "1 / 0", "@", "+", "1 + 2 +"})
    public void wrongCalculate(String expression) {
        Assertions.assertThatThrownBy(() -> {
            Calculate.calculate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
