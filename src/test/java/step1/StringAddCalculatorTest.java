package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("입력받은 숫자가 null일 경우 0으로 간주하고 계산해야 한다.")
    void splitAndSumNull() {
        int result = StringAddCalculator.splitAndSum(null);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력받은 숫자가 empty일 경우 0으로 간주하고 계산해야 한다.")
    void splitAndSumEmpty() {
        int result = StringAddCalculator.splitAndSum("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSumNull2() {
        int result = StringAddCalculator.splitAndSum("1,");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSumEmpty2() {
        int result = StringAddCalculator.splitAndSum("1, ");

        assertThat(result).isEqualTo(1);
    }
}
