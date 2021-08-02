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


        // When
        List<Lotto> lottos = LottoMachine.createLottos(givenMoney);

        // Then

        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }

}
