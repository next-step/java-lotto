package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoStatisticsTest {

    private LottoNumber winOfLottoNumber;

    @BeforeEach
    void setUp() {
        winOfLottoNumber = new LottoNumber(Arrays.asList(3, 4, 5, 1, 2, 10));
    }

    @Test
    void 당첨된_통계를_보여준다() {
        // Given
        Map<Integer, Integer> expectedLottoStrategy = new HashMap<>();
        expectedLottoStrategy.put(3, 1);

        Integer[] givenNumbers = {3, 4, 5, 6, 7, 8};

        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(givenNumbers)));
        List<Lotto> lottos = lottoMachine.sell(new Cache(1000));

        // When
        LottoStatistics lottoStatistics = new LottoStatistics(winOfLottoNumber, lottos);

        // Then
        assertThat(expectedLottoStrategy).isEqualTo(lottoStatistics.resultOfLottos());
    }

    @Test
    void 당청된_수익률을_보여준다() {
        long expectedLottoProfit = 5;
        Integer[] givenNumbers = {3, 4, 5, 6, 7, 8};
        LottoMachine lottoMachine = new LottoMachine(new InputNumberStrategy(Arrays.asList(givenNumbers)));
        List<Lotto> lottos = lottoMachine.sell(new Cache(1000));

        // When
        LottoStatistics lottoStatistics = new LottoStatistics(winOfLottoNumber, lottos);

        // Then
        assertThat(lottoStatistics.getProfit()).isEqualTo(expectedLottoProfit);
    }
}