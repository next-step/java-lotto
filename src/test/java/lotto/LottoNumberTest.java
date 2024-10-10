package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;

class LottoNumberTest {

    @Test
    void 생성() {
        LottoNumber lottoNumber = new LottoNumber(10);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(10));
    }

    @Test
    void 로또_번호는_1부터_45_사이다() {
        assertThatThrownBy(() -> new LottoNumber(46))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumber(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
