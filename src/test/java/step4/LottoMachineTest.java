package step4;

import org.junit.jupiter.api.Test;
import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.Lottos;
import step4.domain.money.Cache;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMachineTest {

    @Test
    void _10000원으로_로또를_10개를_살_수_있다() {
        // Given
        Cache givenCache = new Cache(10000);
        int expectedNumberOfLotto = 10;

        LottoMachine lottoMachine = new LottoMachine(() -> LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));

        // When
        Lottos lottos = lottoMachine.sell(givenCache);

        // Then
        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }

}
