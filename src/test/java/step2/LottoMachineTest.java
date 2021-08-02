package step2;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMachineTest {

    @Test
    void _10000원으로_로또를_10개_만든다() {
        // Given
        int givenMoney = 10000;
        int expectedNumberOfLotto = 10;

        // When
        List<Lotto> lottos = LottoMachine.createLottos(givenMoney);

        // Then
        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }

}
