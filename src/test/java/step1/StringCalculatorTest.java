package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @DisplayName("덧셈 테스트")
    @Test
    public void plusTest() {
        int result = StringCalculator.calculate("1 + 2");
        Assertions.assertThat(result).isEqualTo(3);
    }
}
