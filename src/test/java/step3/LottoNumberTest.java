package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void lottoNumber() {
        LottoNumber lottoNumber1 = new LottoNumber(43);
        LottoNumber lottoNumber2 = new LottoNumber(43);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }
}