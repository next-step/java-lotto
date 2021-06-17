package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @DisplayName(value = "두 로또넘버는 같다.")
    @Test
    void both_lottonumber_is_same() {
        LottoNumber lottoNumber1 = LottoNumber.of(3);
        LottoNumber lottoNumber2 = LottoNumber.of(3);

        assertThat(lottoNumber1.isSame(lottoNumber2)).isTrue();
    }

    @DisplayName(value = "두 로또넘버는 다르다.")
    @Test
    void both_lottonumber_is_different() {
        LottoNumber lottoNumber1 = LottoNumber.of(3);
        LottoNumber lottoNumber2 = LottoNumber.of(5);

        assertThat(lottoNumber1.isSame(lottoNumber2)).isFalse();
    }
}