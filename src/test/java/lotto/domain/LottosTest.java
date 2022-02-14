package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 자동_로또_여러개_생성() {
        Lottos lottos = new Lottos();

        lottos.makeAutoLottos(10);

        assertThat(lottos.getLottos().size()).isEqualTo(10);
    }
}
