package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 번호가 잘 생성되는지")
    @Test
    void lottoNumberTest() {
        assertThat(new LottoNumber(1))
                .isEqualTo(new LottoNumber(1));
    }
}
