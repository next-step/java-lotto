import calculator.StringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class StringCalculatorTest {
    @Test
    void 덧셈() {
        assertThat(StringCalculator.add(1,2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.minus(1,2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(StringCalculator.multiply(1,2)).isEqualTo(2);
    }
}
