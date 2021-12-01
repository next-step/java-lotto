package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumbersTest {

    @Test
    @DisplayName("숫자들의 합계를 구한다")
    void shouldSumNumbers() {
        Numbers numbers = new Numbers(Arrays.asList(new Number("1"), new Number("2")));
        int result = numbers.sum();

        assertThat(result).isEqualTo(3);
    }
}