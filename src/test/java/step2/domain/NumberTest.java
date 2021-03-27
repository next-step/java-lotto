package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    @DisplayName("객체 생성 및 동등성 확인")
    void create_number() {
        // given
        int text = 7;

        // when
        Number number = Number.from(text);

        // then
        assertThat(number).isEqualTo(Number.from(text));
    }
}
