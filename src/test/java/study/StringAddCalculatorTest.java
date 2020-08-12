package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("기본 구분자로 문자열 덧셈")
    void calculate_defaultDelimiter() {
        assertThat(StringAddCalculator.calculate("1:1")).isEqualTo(2);
        assertThat(StringAddCalculator.calculate("1,1")).isEqualTo(2);
    }
}
