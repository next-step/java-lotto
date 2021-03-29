package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.constants.Constants;

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
}
