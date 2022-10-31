package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.strategy.LottoNumbersRandomStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void make() {
        Lotto lotto = LottoFactory.createLotto(new LottoNumbersRandomStrategy());
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    void makeLottos() {
        Lottos lottos = LottoFactory.createLottos(new LottoNumbersRandomStrategy(), 10);
        assertThat(lottos).isNotNull();
        assertThat(lottos.getLottos()).hasSize(10);
    }

    @Test
    void makeManualLottos() {
        Lottos lottos = LottoFactory.createLottos(List.of(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(1, 2, 3, 4, 5, 6)
        ));

        assertThat(lottos).isNotNull();
        assertThat(lottos.getLottos()).hasSize(3);
        assertThat(lottos.getLottos()).allMatch(lotto ->
                lotto.equals(new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6))));
    }
}
