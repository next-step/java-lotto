package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ElementTest {

    @Test
    @DisplayName("연산자가 null이면 에러가 발생해야 한다")
    void createFail() {
        Assertions.assertThatThrownBy(() -> new Element(null, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
