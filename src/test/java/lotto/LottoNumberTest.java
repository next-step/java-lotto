package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoNumberTest {

    @Test
    void lottoNumberCreate() {
        LottoNumber lottoNumber = LottoNumber.of(3);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(3);
    }

    @Test
    void lottoNumberMin1() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
    }

    @Test
    void lottoNumberMax45() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
    }

    @Test
    void 재사용확인() {
        LottoNumber lottoNumber1 = LottoNumber.of(3);
        LottoNumber lottoNumber2 = LottoNumber.of(3);
        assertThat(lottoNumber1.equals(lottoNumber2)).isTrue();

    }
}