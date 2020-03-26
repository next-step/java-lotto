package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("입력받은 문자열이 null일 경우 결과는 0이다.")
    void splitAndSumNull() {
        int result = StringAddCalculator.splitAndSum(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력받은 문자열이 Empty일 경우 결과는 0이다.")
    void splitAndSumEmpty() {
        int result = StringAddCalculator.splitAndSum(" ");

        assertThat(result).isEqualTo(0);
    }
}
