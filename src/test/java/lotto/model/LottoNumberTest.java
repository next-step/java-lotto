package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName(value = "두 로또넘버는 같다.")
    @Test
    void both_lottonumber_is_same() {
        assertThat(LottoNumber.of(1).isSame(LottoNumber.of(1))).isTrue();
    }

    @DisplayName(value = "두 로또넘버는 다르다.")
    @Test
    void both_lottonumber_is_different() {
        assertThat(LottoNumber.of(1).isSame(LottoNumber.of(2))).isFalse();
    }
}