package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringNumberTest {

    @Test
    void parse() {
        StringNumber number = new StringNumber("1");
        assertThat(number.parse()).isEqualTo(1);
    }

    @Test
    @DisplayName("parse에 숫자가 아닌 값 넣을시 RuntimeException")
    void parse_throwRuntimeException() {
        assertThrows(RuntimeException.class, () -> new StringNumber("-a").parse());
    }

    @Test
    @DisplayName("parse에 음수를 넣을시 RuntimeException")
    void parse_throwRuntimeException2() {
        assertThrows(RuntimeException.class, () -> new StringNumber("-1").parse());
    }
}