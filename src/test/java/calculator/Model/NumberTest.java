package calculator.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    Number number;

    @BeforeEach
    public void setUp() {
        number = new Number("0");
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 아닌 문자가 입력되었을 때 return false")
    public void isNumeric_text() {
        boolean expected = false;

        boolean actual = number.isNumeric("abc");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 입력되었을 때 return true")
    public void isNumeric_number() {
        boolean expected = true;

        boolean actual = number.isNumeric("1");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자체크 함수에서 숫자가 입력되었을 때 return true")
    public void changeNumber_number() {
        int expected = 1;

        number.changeNumber(1);
        int actual = number.currentNumber();
        assertThat(actual).isEqualTo(expected);
    }

}