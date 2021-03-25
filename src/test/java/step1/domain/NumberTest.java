package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("음수를 입력하면 RuntimeException 발생한다.")
    @Test
    void negativeNumberImpossible() {
        assertThatThrownBy(() -> Number.from(-1))
                .isInstanceOf(RuntimeException.class);
    }
}