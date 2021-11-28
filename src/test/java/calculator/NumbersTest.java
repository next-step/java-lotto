package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("숫자 하나만 문자열로 입력할 경우 해당 숫자를 반환한다")
    void shouldReturnIfSingleInput() {
        Numbers numbers = new Numbers("1");
        assertThat(numbers.getNumbers()).contains(new Number(1));
    }

    @Test
    @DisplayName("숫자 여러 개를 입력할 경우 쉼표를 구분자로 분리한다")
    void shouldSplitByComma() {
        Numbers numbers = new Numbers("1,2,3", ",");

        assertThat(numbers.getNumbers()).containsExactly(
                new Number(1), new Number(2), new Number(3)
        );
    }

    @Test
    @DisplayName("숫자 여러 개를 입력할 경우 콜론을 구분자로 분리한다")
    void shouldSplitByColon() {
        Numbers numbers = new Numbers("1:2:3", ":");

        assertThat(numbers.getNumbers()).containsExactly(
                new Number(1), new Number(2), new Number(3)
        );
    }
}