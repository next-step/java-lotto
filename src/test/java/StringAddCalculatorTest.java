import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    StringAddCalculator split;

    @BeforeEach
    public void setUp() {
        split = new StringAddCalculator();
    }

    @Test
    void emptyString() {
        int result = split.splitAndSum(null);
        assertThat(result).isEqualTo(0);
        result = split.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void stringOne() throws Exception {
        int result = split.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

}
