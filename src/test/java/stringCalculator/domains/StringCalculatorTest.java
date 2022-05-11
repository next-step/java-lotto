package stringCalculator.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @DisplayName("입력 순서대로 계산 순서가 결정")
    @Test
    void calculate() {
        int result = StringCalculator.calculate("1 + 2 * 3");

        assertThat(result).isEqualTo(9);
    }
}
