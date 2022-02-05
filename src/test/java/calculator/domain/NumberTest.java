package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 숫자_외_문자가_들어온경우_예외발생() {
        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Number.from("cdc"));
    }

    @Test
    void 숫자가_음수면_예외발생(){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Number.from("-1"));
    }
}
