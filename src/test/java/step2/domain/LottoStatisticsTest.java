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
        Map<Integer, Integer> expected = new HashMap<>();
        //expected.put(3, 1);
        expected.put(6, 2);

        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(3, 4, 5, 6, 7, 8)));

        LottoNumber winOfLottoNumber = lottoMachine.winOfLotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        List<Lotto> lottos = lottoMachine.createLottos(new Wallet(new Cache(2000)));
        LottoStatistics lottoStatistics = new LottoStatistics(winOfLottoNumber);

        // When
        lottoStatistics.lottoOfStatistics(lottos);

        // Then
        assertThat(expected).isEqualTo(lottoStatistics.resultOfLotto());
    }
}