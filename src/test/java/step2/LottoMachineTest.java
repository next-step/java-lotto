package step2;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMachineTest {

    @Test
    void 투입_금액만큼_로또를_만든다() {
        // Given
        int givenMoney = 10000;
        int expectedNumberOfLotto = 10;

        LottoMachine lottoMachine = new LottoMachine();
        // When
        List<Lotto> lottos = lottoMachine.createLottos(givenMoney);

        // Then

        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }

}
