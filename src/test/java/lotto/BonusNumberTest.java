package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumber;

class BonusNumberTest {

    @Test
    void 보너스_번호는_0부터_45사이_숫자다() {
        assertThatThrownBy(() -> new BonusNumber(-1))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber(46))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호를_로또_번호로_변환한다() {
        BonusNumber bonusNumber = new BonusNumber(10);

        LottoNumber lottoNumber = bonusNumber.toLottoNumber();

        assertThat(lottoNumber).isEqualTo(new LottoNumber(10));
    }
}
