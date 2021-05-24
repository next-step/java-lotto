package step3;

import org.junit.jupiter.api.Test;
import step3.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void sameLottoNumber() {
        LottoNumber lottoNumber1 = new LottoNumber(43);
        LottoNumber lottoNumber2 = new LottoNumber(43);

        assertThat(lottoNumber1.valueOf()).isEqualTo(lottoNumber2.valueOf());
    }


    @Test
    void notSameLottoNumber() {
        LottoNumber lottoNumber1 = new LottoNumber(43);
        LottoNumber lottoNumber2 = new LottoNumber(45);

        assertThat(lottoNumber1).isNotEqualTo(lottoNumber2);
    }
}