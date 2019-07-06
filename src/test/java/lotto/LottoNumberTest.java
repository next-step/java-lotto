package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoNumberTest {

    @Test
    void lottoNumberCreate() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(3);
    }

    @Test
    void lottoNumberMin1() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
    }

    @Test
    void lottoNumberMax45() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
    }
}