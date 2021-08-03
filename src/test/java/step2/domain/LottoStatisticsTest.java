package step2.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoStatisticsTest {

    @Test
    void 당첨된_통계를_보여준다() {
        // Given
        Map<Integer, Integer> expectedLottoStrategy = new HashMap<>();
        expectedLottoStrategy.put(6, 3);

        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(3, 4, 5, 6, 7, 8)));

        LottoNumber winOfLottoNumber = lottoMachine.winOfLotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        List<Lotto> lottos = lottoMachine.createLottos(new Wallet(new Cache(3000)));
        LottoStatistics lottoStatistics = new LottoStatistics(winOfLottoNumber);

        // When
        lottoStatistics.lottoOfStatistics(lottos);

        // Then
        assertThat(expectedLottoStrategy).isEqualTo(lottoStatistics.calculate());
    }
}