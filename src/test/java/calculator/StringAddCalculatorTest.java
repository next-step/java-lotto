package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("null 또는 빈문자")
    @Test
    void splitAndSum_null_or_emptyStr() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(" ");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자하나")
    @Test
    void splitAndSum_singleNum() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    private static class StringAddCalculator {
        public static int splitAndSum(String text) {
            if(null == text || "".equals(text.trim())){
                return 0;
            }
            return Integer.parseInt(text);
        }
    }
}
