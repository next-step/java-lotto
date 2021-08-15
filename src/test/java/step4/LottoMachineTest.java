package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoMachine;
import step4.domain.lotto.Lottos;
import step4.domain.money.Cache;
import step4.domain.money.Money;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("5000원으로 로또를 수동으로 2개 랜덤 3개를 살 수 있다")
    @Test
    void sell() {
        // Given
        Money givenCache = new Cache(5000);
        Money givenManualCache = new Cache(2000);
        Money givenRandomCache = givenCache.minus(givenManualCache);

        List<Lotto> givenLottos = LottoMachine.randomLottoBulk(givenRandomCache);
        
        Lotto manualLottos1 = LottoMachine.manualLotto(givenManualCache, LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto manualLottos2 = LottoMachine.manualLotto(givenManualCache, LottoNumbersFactory.buildLottoNumbers(11, 12, 13, 14, 15, 16));

        givenLottos.add(manualLottos1);
        givenLottos.add(manualLottos2);

        // When
        Lottos actualLottos = new Lottos(givenLottos);

        // Then
        assertThat(manualLottos1.numbers()).isEqualTo(LottoNumbersFactory.buildLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(manualLottos2.numbers()).isEqualTo(LottoNumbersFactory.buildLottoNumbers(11, 12, 13, 14, 15, 16));
        assertThat(actualLottos.getLottoCount()).isEqualTo(5);
    }

}
