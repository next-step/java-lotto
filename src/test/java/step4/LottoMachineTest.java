package step4;

import org.junit.jupiter.api.Test;
import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.Lottos;
import step4.domain.lotto.RandomStrategy;
import step4.domain.money.Cache;
import step4.domain.money.Money;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMachineTest {

    @Test
    void _10000원으로_로또를_10개를_살_수_있다() {
        // Given
        Cache givenCache = new Cache(10000);
        int expectedNumberOfLotto = 10;

        LottoMachine lottoMachine = new LottoMachine();

        // When
        Lottos lottos = lottoMachine.sell(givenCache, () -> LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));

        // Then
        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }

    @Test
    void _10000원으로_로또를_수동으로_10개를_살_수_있다() {
        // Given
        Cache givenCache = new Cache(10000);
        int expectedNumberOfLotto = 10;

        LottoMachine lottoMachine = new LottoMachine();

        // When
        Lottos lottos = lottoMachine.sell(givenCache, () -> LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));

        // Then
        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }


    @Test
    void _10000원으로_로또를_수동으로_3개_랜덤_7개를_살_수_있다() {
        // Given
        Money givenCache = new Cache(10000);
        Money givenManualCache = new Cache(3000);
        Money givenRandomCache = givenCache.minus(givenManualCache);

        LottoMachine lottoManualMachine = new LottoMachine();
        LottoMachine lottoRandomMachine = new LottoMachine();

        // When
        Lottos manualLottos = lottoManualMachine.sell(givenManualCache, () -> LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        Lottos randomLottos = lottoRandomMachine.sell(givenRandomCache, new RandomStrategy());

        // Then
        assertThat(manualLottos.size()).isEqualTo(3);
        assertThat(randomLottos.size()).isEqualTo(7);
    }

}
