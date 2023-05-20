package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class StatisticsTest {
    private String winnerLottoNumber = "1, 2, 3, 4, 5, 6";

    @Test
    void StatisticsTest_PrizeType_THREE() {
        Statistics statistics = new Statistics();
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.createManualLotto("1,2,3,7,8,9")
                , Lotto.createManualLotto("1,2,3,7,8,9")));

        assertThat(statistics.generate(lottos, winnerLottoNumber,10).get(RankType.FIFTH)).isEqualTo(2);
    }

    @Test
    void StatisticsTest_PrizeType_not_match() {
        Statistics statistics = new Statistics();
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.createManualLotto("1,2,10,7,8,9")
                , Lotto.createManualLotto("1,2,11,7,8,9")));

        assertThat(statistics.generate(lottos, winnerLottoNumber, 10).get(RankType.FIFTH)).isEqualTo(0);
    }

    @Test
    void StatisticsTest_수익률() {
        Statistics statistics = new Statistics();
        Lottos lottos = new Lottos(Arrays.asList(
                Lotto.createManualLotto("1,2,3,7,8,9")));

        statistics.generate(lottos, winnerLottoNumber, 10);

        assertThat(statistics.getRateOfReturn(14000)).isEqualTo(0.35);
    }

    @Test
    void StatisticsTest_2등() {
        Statistics statistics = new Statistics();
        Lottos lottos = new Lottos(Arrays.asList(Lotto.createManualLotto("1,2,3,4,5,9")));

        assertThat(statistics.generate(lottos, winnerLottoNumber, 9).get(RankType.SECOND)).isEqualTo(1);
    }
    @Test
    void StatisticsTest_3등() {
        Statistics statistics = new Statistics();
        Lottos lottos = new Lottos(Arrays.asList(Lotto.createManualLotto("1,2,3,4,5,9")));

        assertThat(statistics.generate(lottos, winnerLottoNumber, 7).get(RankType.THIRD)).isEqualTo(1);
    }
}