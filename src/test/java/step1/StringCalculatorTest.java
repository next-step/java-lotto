package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void before() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("입력값이 null 또는 빈값일 경우 IllegalArgumentException이 발생한다.")
    void 입력값_null_또는_빈값() {
        assertThatThrownBy(() -> {
            stringCalculator.splitAndCalculate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산자가 아닌 기호가 포함되어 있는 경우 IllegalArgumentException이 발생한다.")
    void 사칙연산자_아닌_기호_포함() {
        assertThatThrownBy(() -> {
            stringCalculator.splitAndCalculate("2 + 3 @ 4 / 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2 를 인자로 넘겼을 때 합산된 값 10을 반환한다.")
    void name() {
        int result = stringCalculator.splitAndCalculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}
