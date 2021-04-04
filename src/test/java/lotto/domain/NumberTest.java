package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.constants.Constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("로또 범위 초과 숫자 입력시 RuntimeException 발생한다")
    void range_exceed_expcetion() {
        assertThatThrownBy(() -> Number.from(Constants.LOTTO_MIN_BOUND - 1))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> Number.from(Constants.LOTTO_MAX_BOUND + 1))
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    @DisplayName("Number 클래스에 equals를 재정의하지 않았는데도 동등한지 확인한다")
    void caching_test() {
        Number number = Number.from(1);
        assertThat(number).isEqualTo(Number.from(1));
    }
}
