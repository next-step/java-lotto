import calculator.StringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class StringCalculatorTest {
    @Test
    void 더하기() {
        assertThat(StringCalculator.add(1,2)).isEqualTo(3);
    }
}
