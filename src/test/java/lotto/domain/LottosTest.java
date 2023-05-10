package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    void lottosTest_generateLottos() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.count()).isEqualTo(14);
    }
}