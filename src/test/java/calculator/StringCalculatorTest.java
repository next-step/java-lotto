package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void 복수_연산() {
        // given
        String input = "2 + 1 * 3 - 6 / 2";

        // when
        int result = StringCalculator.calculate(input);

        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
}
