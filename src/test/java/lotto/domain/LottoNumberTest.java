package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
         assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @Test
    void create2() {
        LottoNumber lottoNumber = LottoNumber.of("1");
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @Test
    void save_invalid() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));

        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of(1) == lottoNumber).isTrue();
    }

    @Test
    void makeLottoTest() {
        assertThat(LottoNumber.makeLotto().size()).isEqualTo(6);
    }
}