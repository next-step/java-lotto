package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.from(45);
        assertThat(LottoNumber.from(45)).isEqualTo(lottoNumber);
    }

    @Test
    void 로또_유효숫자_X() {
        assertThatThrownBy(() -> LottoNumber.from(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
