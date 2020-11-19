package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    @DisplayName("정상적인 Number객체 생성")
    void createNumber() {
        String numStr = "1";

        Number number = new Number(numStr);

        assertThat(number).isEqualTo(new Number(numStr));
    }

    @Test
    @DisplayName("음수가 들어올 시 Runtime에러")
    void createNumber_input_negative_number() {
        String numStr = "-1";

        assertThatThrownBy(() -> new Number(numStr))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 음수입니다.");
    }

    @Test
    @DisplayName("숫자아닌 값이 들어올 시 Runtime에러")
    void createNumber_input_not_int() {
        String numStr = "*";

        assertThatThrownBy(() -> new Number(numStr))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("input string: \"*\"");
    }
}
