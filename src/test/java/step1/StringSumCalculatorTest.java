package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringSumCalculatorTest {

    @Test
    @DisplayName("문자열을 입력받을 때, 빈 문자열인 경우 0을 리턴한다.")
    void input_test() {
        StringSumCalculator stringSumCalculator = new StringSumCalculator();
        int result = stringSumCalculator.sum(null);
        assertThat(result).isEqualTo(0);

        result = stringSumCalculator.sum("");
        assertThat(result).isEqualTo(0);
    }
}