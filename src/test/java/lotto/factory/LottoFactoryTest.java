package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.strategy.LottoNumbersRandomStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void make() {
        Lotto lotto = LottoFactory.createLotto(new LottoNumbersRandomStrategy());
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    void makeLottos() {
        Lottos lottos = LottoFactory.createLottos(new LottoNumbersRandomStrategy(), 10000);
        assertThat(lottos).isNotNull();
        assertThat(lottos.getLottos()).hasSize(10);
    }
}
