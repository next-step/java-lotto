package lotto.domain;

import lotto.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {
    @Test
    void 통계() {
        Lotto winningLotto = new Lotto(new RandomNumberStrategy());
        Purchasing purchasing = new Purchasing(50000);
        List<Long> matchCntList =  purchasing.getMatchCntList(winningLotto);

        Statistics statistics = new Statistics();
        Map<WinnigType, Integer> statisticsMap = statistics.getStatistics(matchCntList);

        for (Integer cnt : statisticsMap.values()) {
            assertThat(cnt).isLessThanOrEqualTo(50);
        }
    }
}