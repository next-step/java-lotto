package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringNumbersTest {

    @DisplayName("합계 구하기")
    @Test
    void sum() {
        String[] input = {"1", "2", "3"};
        StringNumbers numbers = new StringNumbers(input);
        int result = numbers.sum();
        assertThat(result).isEqualTo(6);
    }
}