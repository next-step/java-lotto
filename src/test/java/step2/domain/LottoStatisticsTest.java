package step2.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
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

        // When
        LottoStatistics lottoStatistics = new LottoStatistics(winOfLottoNumber, lottos);

        // Then
        assertThat(expectedLottoStrategy).isEqualTo(lottoStatistics.resultOfLottos());
    }

    @Test
    void 당청된_수익률을_보여준다() {
        long expectedLottoProfit = 500L;
        Integer[] givenNumbers = {3, 4, 5, 6, 7, 8};
        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(givenNumbers)));
        LottoNumber winOfLottoNumber = lottoMachine.winOfLotto(Arrays.asList(3, 4, 5, 1, 2, 10));
        List<Lotto> lottos = lottoMachine.createLottos(new Wallet(new Cache(1000)));

        // When
        LottoStatistics lottoStatistics = new LottoStatistics(winOfLottoNumber, lottos);

        // Then
        assertThat(lottoStatistics.getProfit()).isEqualTo(BigDecimal.valueOf(expectedLottoProfit));
    }
}