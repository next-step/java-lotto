package lotto.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatchingResultsTest {
    @Test
    public void getProfit_MISS() {
        MatchingResults result = new MatchingResults(5);
        result.add(Rank.MISS);
        assertEquals(0.0, result.getProfit(), 0.001);
    }

    @Test
    public void getProfit_THIRD_FORTH() {
        MatchingResults result = new MatchingResults(100);
        result.add(Rank.THIRD);
        result.add(Rank.FOURTH);
        assertEquals(15.0, result.getProfit(), 0.001);
    }

    @Test
    public void getProfit_FIRST() {
        MatchingResults result = new MatchingResults(100);
        result.add(Rank.FIRST);
        assertEquals(20000.0, result.getProfit(), 0.001);
    }
}
