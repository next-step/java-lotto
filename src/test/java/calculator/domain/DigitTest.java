package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class DigitTest {

    @Test
    @DisplayName("생성/숫자인문자열/숫자로생성")
    void createDigit() {
        // when
        Digit digit = new Digit("9");

        // then
        assertThat(digit.getNum()).isEqualTo(9);
    }

    @Test
    @DisplayName("생성실패/숫자가아닌문자열/IllegalArgumentException")
    void createDigitFailNotInt() {
        // when then
        assertThatThrownBy(() -> new Digit("+")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("생성실패/0~9가아닌문자열/IllegalArgumentException")
    void createDigitFailNotDigits() {
        // when then
        assertThatIllegalArgumentException().isThrownBy(() -> new Digit("10"));
    }
}