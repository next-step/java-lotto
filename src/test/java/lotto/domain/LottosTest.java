package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 로또들_생성() {
        int lottoCount = 5;
        Lottos lottos = new Lottos(lottoCount);
        assertThat(lottos).isNotNull();
    }
}