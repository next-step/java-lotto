package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @Test
    @DisplayName("로또 번호 생성")
    void create() {
        LottoNumber lottoNumber = new LottoNumber(8);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(8));
    }
}