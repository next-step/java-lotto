package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    void 숫자체크() {
        assertThatThrownBy(() -> {
            new Number("str");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
