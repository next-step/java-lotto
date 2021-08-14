package step4;

import org.junit.jupiter.api.Test;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.Lottos;
import step4.domain.money.Cache;
import step4.domain.money.Money;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    void _5000원으로_로또를_수동으로_2개_랜덤_3개를_살_수_있다() {
        // Given
        Money givenCache = new Cache(5000);
        Money givenManualCache = new Cache(2000);
        Money givenRandomCache = givenCache.minus(givenManualCache);

        List<Lotto> lottos = LottoMachine.randomLottoBulk(givenRandomCache);
        Lotto manualLottos1 = LottoMachine.manualLotto(givenManualCache, LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto manualLottos2 = LottoMachine.manualLotto(givenManualCache, LottoNumbersFactory.buildLottoNumbers(11, 12, 13, 14, 15, 16));
        lottos.add(manualLottos1);
        lottos.add(manualLottos2);

        // When
        Lottos actualLottos = new Lottos(lottos);

        // Then
        assertThat(manualLottos1.numbers()).isEqualTo(LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(manualLottos2.numbers()).isEqualTo(LottoNumbersFactory.buildLottoNumbers(11, 12, 13, 14, 15, 16));
        assertThat(actualLottos.getLottoCount()).isEqualTo(5);
    }

}
