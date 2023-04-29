package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
        assertThatThrownBy(() -> LottoNumber.valueOf(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumber.valueOf(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
