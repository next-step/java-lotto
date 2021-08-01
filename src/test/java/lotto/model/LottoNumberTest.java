package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void toInt() {
        LottoNumber lottoNumber = LottoNumber.from(1);
        Assertions.assertThat(lottoNumber.toInt()).isEqualTo(1);
    }
}
