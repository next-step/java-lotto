package step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    @DisplayName("Number 객체 생성")
    void create_number() {
        // given
        int text = 7;

        // when
        Number number = Number.from(text);

        // then
        assertThat(number).isEqualTo(Number.from(text));
    }

    @Test
    @DisplayName("음수를 입력하면 RuntimeException 발생한다.")
    void negativeNumberImpossible() {
        assertThatThrownBy(() -> Number.from(-1))
                .isInstanceOf(RuntimeException.class);
    }
}