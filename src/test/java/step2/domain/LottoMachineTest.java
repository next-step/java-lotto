package step2.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMachineTest {

    @Test
    void _10000원으로_로또를_10개_만든다() {
        // Given
        Cache givenCache = new Cache(10000);
        int expectedNumberOfLotto = 10;

        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // When
        List<Lotto> lottos = lottoMachine.sell(new Wallet(givenCache));

        // Then
        assertThat(lottos.size()).isEqualTo(expectedNumberOfLotto);
    }

}
