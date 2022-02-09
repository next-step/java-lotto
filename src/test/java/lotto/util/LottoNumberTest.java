package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 로또_만들_리스트_생성() {
        LottoNumber lottoNumber = new LottoNumber();

        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(45);
    }
}