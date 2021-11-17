package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTest {

    @Test
    void 숫자를_생성한다() {
        //given
        Number number = Number.create(2);
        //when & then
        assertThat(number.getNumber()).isEqualTo(2);
    }

    @Test
    void 범위_1이상_45이하의_숫자가_아니면_IllegalArgumentException_이_발생한다() {
        assertThatThrownBy(() -> Number.of("46")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Number.of("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자를_비교한다() {
        //given
        //when
        //then
        assertEquals(Number.of("1"), Number.of("1"));
    }
}
