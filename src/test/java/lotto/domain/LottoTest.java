package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 로또번호를_만든다() {
        Lotto lotto = Lotto.create();
        assertThat(lotto.getLottoNumber()).size().isEqualTo(6);
    }

}