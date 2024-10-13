package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(45);
        assertThat(new LottoNumber(45)).isEqualTo(lottoNumber);
    }

    @Test
    void 로또_유효숫자_X() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
