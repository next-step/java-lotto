package step2step3.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberStorageTest {
    @Test
    void 저장된_로또를_반환받는다() {
        LottoNumberStorage lottoNumberStorage = new LottoNumberStorage();

        assertThat(lottoNumberStorage.lottoNumber(5)).isEqualTo(new LottoNumber(5));
    }
}
