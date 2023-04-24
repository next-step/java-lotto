package calculator.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    @Test
    @DisplayName("숫자체크 함수에서 숫자가 아닌 문자가 입력되었을 때 return false")
    public void isNumeric_text() {
        boolean expected = false;

        boolean actual = Number.isNumeric("abc");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 입력되었을 때 return true")
    public void isNumeric_number() {
        boolean expected = true;

        boolean actual = Number.isNumeric("1");
        assertThat(actual).isEqualTo(expected);
    }

}