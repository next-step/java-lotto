package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void 생성() {
        Lottos lottos = new Lottos(14);
        assertThat(lottos.lottos()).hasSize(14);
    }
}