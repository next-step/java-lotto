package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TokenTest {

    @Test
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.")
    void valid() {
        assertThatThrownBy(() -> new Token("-1,2,3"))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> new Token("A,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
