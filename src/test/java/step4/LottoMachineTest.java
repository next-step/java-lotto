package step4;

import org.junit.jupiter.api.Test;
import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.Lottos;
import step4.domain.lotto.RandomStrategy;
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

    @Test
    void _10000원으로_로또를_수동으로_10개를_살_수_있다() {
        // Given
        Cache givenCache = new Cache(10000);
        int expectedNumberOfLotto = 10;

        LottoMachine lottoMachine = new LottoMachine(() -> LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));

        // When
        Lottos lottos = lottoMachine.sell(givenCache);

        // Then
        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }


    @Test
    void _10000원으로_로또를_수동으로_3개_랜덤_7개를_살_수_있다() {
        // Given
        Cache givenManualCache = new Cache(3000);
        Cache givenRandomCache = new Cache(7000);

        LottoMachine lottoManualMachine = new LottoMachine(() -> LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoMachine lottoRandomMachine = new LottoMachine(new RandomStrategy());

        // When
        Lottos manualLottos = lottoManualMachine.sell(givenManualCache);
        Lottos randomLottos = lottoRandomMachine.sell(givenRandomCache);

        // Then
        assertThat(manualLottos.size()).isEqualTo(3);
        assertThat(randomLottos.size()).isEqualTo(7);
    }

}
