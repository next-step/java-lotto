package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void instanceCaching() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        Assertions.assertThat(LottoNumber.of(1)).isEqualTo(lottoNumber);
        Assertions.assertThat(LottoNumber.of(1).equals(lottoNumber)).isTrue();
    }
}