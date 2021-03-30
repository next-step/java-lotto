package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    private List<Rank> winningResults;
    private Statistics statistics;

    @BeforeEach
    public void setWinningResults() {
        winningResults = Arrays.asList(Rank.FIFTH, Rank.OTHER, Rank.FIFTH);
        statistics = new Statistics(winningResults);
    }

    @Test
    public void statistics() {
        // given
        Map<Rank, Integer> expectStatistics = new HashMap<>();
        expectStatistics.put(Rank.FIRST, 0);
        expectStatistics.put(Rank.THIRD, 0);
        expectStatistics.put(Rank.FOURTH, 0);
        expectStatistics.put(Rank.FIFTH, 2);
        expectStatistics.put(Rank.OTHER, 1);

        // when
        Map<Rank, Integer> resultStatistics = statistics.getStatistics();

        // then
        assertThat(resultStatistics).isEqualTo(expectStatistics);
    }

    @Test
    public void yield() {
        // given
        int purchaseAmount = 3000;
        double expectYield = (double) 10000 / purchaseAmount;

        // when
        double resultYield = statistics.yield(purchaseAmount);

        // then
        assertThat(resultYield).isEqualTo(expectYield);
    }
}
