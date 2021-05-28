package step3;

import org.junit.jupiter.api.Test;
import step3.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void sameLottoNumber() {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(43);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(43);

        assertThat(lottoNumber1).isSameAs(lottoNumber2);
    }


    @Test
    void notSameLottoNumber() {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(43);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(45);

        assertThat(lottoNumber1).isNotSameAs(lottoNumber2);
    }
}