package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {
    @Test
    public void create() {
        LottoNumber lottoNumber = LottoNumber.valueOf(1);
        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @Test
    public void equal() {
        LottoNumber lottoNumber = LottoNumber.valueOf(1);
        assertThat(lottoNumber.equals(LottoNumber.valueOf(1))).isTrue();
    }

    @Test
    void exception() {
        assertThat(LottoNumber.valueOf(0)).isInstanceOf(IllegalArgumentException.class);
        assertThat(LottoNumber.valueOf(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
