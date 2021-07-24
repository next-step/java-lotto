package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    @DisplayName("음수를 입력할 경우 RuntimeException 이 발생한다.")
    @Test
    void minus_number() {
        assertThatThrownBy(() -> PositiveNumber.of("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}