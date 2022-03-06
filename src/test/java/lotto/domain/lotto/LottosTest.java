package lotto.domain.lotto;

import lotto.domain.LottoFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void 수동로또와_자동로또를_합쳐서_저장한다() {
        Lottos lottos = new Lottos(LottoFixtures.HAND_LOTTOS, LottoFixtures.AUTOMATIC_LOTTOS);
        final int expect = LottoFixtures.HAND_LOTTOS.size() + LottoFixtures.AUTOMATIC_LOTTOS.size();
        assertThat(lottos.getLottos()).hasSize(expect);
    }
}