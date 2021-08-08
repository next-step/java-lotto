package step3.domain;

import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoMachine;
import step3.domain.money.Cache;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMachineTest {

    @Test
    void _10000원으로_로또를_10개를_살_수_있다() {
        // Given
        Cache givenCache = new Cache(10000);
        int expectedNumberOfLotto = 10;

        LottoMachine lottoMachine = new LottoMachine(() -> LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));

        // When
        List<Lotto> lottos = lottoMachine.sell(givenCache);

        // Then
        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }

}
