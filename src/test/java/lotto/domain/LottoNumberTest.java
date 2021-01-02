package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);
         assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void create2() {
        LottoNumber lottoNumber = new LottoNumber("1");
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void save_invalid() {
        assertThat(LottoNumber.of(1)).isEqualTo(new LottoNumber(1));

        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of(1) == lottoNumber).isTrue();
    }
}