package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("[StringCalculator.cal] 피연산자 2개의 덧셈 계산식 -> 합계 반환")
    public void simpleSumTest() {
        assertThat(StringCalculator.cal("3 + 6"))
                .isEqualTo(9);
    }
}
