package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 정상_로또_숫자_생성() {
        LottoNumber lottoNumber = new LottoNumber(20);

        assertThat(lottoNumber.getLottoNumber()).isEqualTo(20);
    }

    @Test
    void 범위_초과_로또_숫자_생성() {
        assertThatThrownBy(() -> new LottoNumber(100))
            .isInstanceOf(IllegalArgumentException.class);
    }
}