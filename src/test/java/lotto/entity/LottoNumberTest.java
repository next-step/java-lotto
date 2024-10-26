package lotto.entity;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 로또_숫자_범위_검증_예외() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_숫자_같은_객체인지_검증() {
        LottoNumber lottoNumber = new LottoNumber(45);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(45));
    }
}
