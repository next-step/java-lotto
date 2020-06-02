package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 로또번호를_만든다() {
        Lotto lotto = Lotto.create();
        assertThat(lotto.getLottoNumber()).size().isEqualTo(6);

        //랜덤 번호에 대해 어떤 테스트를 해야???
    }

}