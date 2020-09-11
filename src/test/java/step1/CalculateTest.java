package step1;

import org.junit.jupiter.api.Test;
import step1.util.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    @Test
    void splitAndSum_null_또는_공백() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }
}
