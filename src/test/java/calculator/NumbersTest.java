package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("숫자 하나만 문자열로 입력할 경우 해당 숫자를 저장한다")
    void shouldReturnIfSingleInput() {
        Numbers numbers = new Numbers(1);
        assertThat(numbers).isEqualTo(new Numbers(1));
    }

    @Test
    @DisplayName("숫자 여러 개를 입력할 경우 해당 숫자들을 저장한다")
    void shouldSplitByComma() {
        List<Number> input = Arrays.asList(new Number(1), new Number(2));
        Numbers numbers = new Numbers(input);

        assertThat(numbers).isEqualTo(new Numbers(input));
    }
}