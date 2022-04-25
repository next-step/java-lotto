package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    @DisplayName("공란으로 생성시 NumberFormatException 반환한다.")
    void invalidNumber() {
        assertThatThrownBy(() -> new Number(" "))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("null 값으로 생성시 NumberFormatException 반환한다.")
    void nullCheck() {
        assertThatThrownBy(() -> new Number(null))
                .isInstanceOf(NumberFormatException.class);
    }
}