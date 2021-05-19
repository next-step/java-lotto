package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @DisplayName("숫자인 문자를 입력하면 합계가 반환된다")
    @Test
    void sum() {
        // given
        List<String> values = Arrays.asList("1", "2", "3");
        Numbers numbers = Numbers.from(values);

        // when
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다")
    @Test
    void validate_number() {
        // given
        List<String> values = Arrays.asList("1", "2", "삼", "one");

        // when

        // then
        assertThatThrownBy(() -> Numbers.from(values))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("only number are available");
    }
}
