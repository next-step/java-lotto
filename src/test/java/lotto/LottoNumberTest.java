package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoNumberPicker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoNumberTest {

    private static final int TEST_LOTTO_NUBMER = 1;

    @Test
    void 로또_숫자_값_체크() {
        LottoNumber lottoNumber = new LottoNumber(TEST_LOTTO_NUBMER);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(TEST_LOTTO_NUBMER);
    }

    @Test
    void 로또_숫자_값_체크2() {
        LottoNumber lottoNumber = LottoNumberPicker.pickNumber(TEST_LOTTO_NUBMER);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(TEST_LOTTO_NUBMER);
    }

    @Test
    void 로또_숫자_예외() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
