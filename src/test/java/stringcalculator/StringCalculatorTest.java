package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생한다")
    void null_Or_blank_IllegalArgumentException() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertThatThrownBy(() -> { stringCalculator.calculate(null); }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> { stringCalculator.calculate(""); }).isInstanceOf(IllegalArgumentException.class);
    }
}
