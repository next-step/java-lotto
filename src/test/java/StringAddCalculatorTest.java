import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }
}
