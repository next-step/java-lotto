package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("문자열을 공백 기준 분리한다")
    @Test
    void splitBySpace() {
        assertThat(StringCalculator.split("1 + 2")).containsExactly("1", "+", "2");
    }

    @DisplayName("문자열에서 연속 공백을 무시하고 분리한다")
    @Test
    void splitByMultipleSpaces() {
        assertThat(StringCalculator.split("1  +   2")).containsExactly("1", "+", "2");
    }

    @DisplayName("문자열 앞뒤 공백을 무시하고 분리한다")
    @Test
    void splitByTrimmedSpaces() {
        assertThat(StringCalculator.split(" 1 + 2 ")).containsExactly("1", "+", "2");
    }
}
