package step2.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @RepeatedTest(10)
    void 범위_1_이상_45_이하의_랜덤한_숫자를_생성한다() {
        //given
        Number number = Number.create();
        //when & then
        assertThat(number.getNumber()).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
    }

    @Test
    void 범위_1이상_45이하의_숫자가_아니면_IllegalArgumentException_이_발생한다() {
        assertThatThrownBy(() -> Number.of("46")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Number.of("0")).isInstanceOf(IllegalArgumentException.class);
    }
}
