package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    void 소수점_두자리() {
        double cal = Math.floor(((double) 5000 / 14000) * 100) / 100;
        double result = 0.35;
        assertThat(cal).isEqualTo(result);
    }
}
