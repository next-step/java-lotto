package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumbersTest {

    @Test
    @DisplayName("숫자가 아닌 문자가 입력될 경우 RuntimeException 발생한다")
    void validate() {
        List<String> inputs = Arrays.asList("1", "2", "삼");
        assertThatThrownBy(() -> Numbers.from(inputs))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자의 합계가 반환된다")
    void sum() {
        // given
        List<String> inputs = Arrays.asList("1", "2", "3");
        Numbers numbers = Numbers.from(inputs);

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }
}