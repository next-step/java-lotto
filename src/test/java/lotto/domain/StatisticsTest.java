package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class StatisticsTest {
    @Test
    void StatisticsTest_PrizeType_THREE() {
        Statistics statistics = new Statistics();
        String inputLottoNumber = "1, 2, 3, 4, 5, 6";
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,3,7,8,9")
                , new Lotto("1,2,3,7,8,9")));

        assertThat(statistics.generator(lottos, inputLottoNumber).get(PrizeType.THREE)).isEqualTo(2);
    }

    @Test
    void StatisticsTest_PrizeType_not_match() {
        Statistics statistics = new Statistics();
        String inputLottoNumber = "1, 2, 3, 4, 5, 6";
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,10,7,8,9")
                , new Lotto("1,2,11,7,8,9")));

        assertThat(statistics.generator(lottos, inputLottoNumber).get(PrizeType.THREE)).isEqualTo(0);
    }

    @Test
    void StatisticsTest_수익률() {
        Statistics statistics = new Statistics();
        String inputLottoNumber = "1, 2, 3, 4, 5, 6";
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1,2,3,7,8,9")));

        statistics.generator(lottos, inputLottoNumber);

        assertThat(statistics.getRateOfReturn(14000)).isEqualTo(0.35);
    }
}