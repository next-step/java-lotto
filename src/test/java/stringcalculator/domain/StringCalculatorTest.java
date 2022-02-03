package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @DisplayName("연산결과 테스트")
    @Test
    void testCalculatorOperation() {
        int result = StringCalculator.execute(Arrays.asList(1, 2, 3, 4));
        assertThat(result).isEqualTo(10);
    }
}