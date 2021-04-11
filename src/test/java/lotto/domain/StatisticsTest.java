package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    private List<Rank> winningResults;
    private Statistics statistics;

    @BeforeEach
    public void setWinningResults() {
        winningResults = Arrays.asList(Rank.FIFTH, Rank.OTHER, Rank.FIFTH, Rank.SECOND);
        statistics = new Statistics(winningResults);
    }

    @Test
    public void statistics() {
        // given
        Map<Rank, Integer> expectStatistics = new LinkedHashMap<>();
        expectStatistics.put(Rank.OTHER, 1);
        expectStatistics.put(Rank.FIFTH, 2);
        expectStatistics.put(Rank.FOURTH, 0);
        expectStatistics.put(Rank.THIRD, 0);
        expectStatistics.put(Rank.SECOND, 1);
        expectStatistics.put(Rank.FIRST, 0);
        Iterator<Rank> expectIterator = expectStatistics.keySet().iterator();

        // when
        Map<Rank, Integer> resultStatistics = statistics.getStatistics();
        Iterator<Rank> resultIterator = resultStatistics.keySet().iterator();


        // then
        while (resultIterator.hasNext() && expectIterator.hasNext()) {
            assertThat(resultIterator.next()).isEqualTo(expectIterator.next());
        }
    }

    @Test
    public void yield() {
        // given
        int purchaseAmount = 3000;
        double expectYield = (double) 30010000 / purchaseAmount;

        // when
        double resultYield = statistics.yield(purchaseAmount);

        // then
        assertThat(resultYield).isEqualTo(expectYield);
    }
}
