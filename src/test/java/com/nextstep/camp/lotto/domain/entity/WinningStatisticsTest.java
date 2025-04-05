package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.type.Rank;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.Ranks;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningStatisticsTest {

    static Stream<TestCase> provideStatistics() {
        return Stream.of(
            new TestCase(
                List.of(Rank.THREE, Rank.THREE, Rank.FOUR, Rank.SIX, Rank.NONE),
                LottoAmount.of(5000),
                Map.of(
                    Rank.THREE, 2,
                    Rank.FOUR, 1,
                    Rank.FIVE, 0,
                    Rank.FIVE_BONUS, 0,
                    Rank.SIX, 1
                ),
                2 * 5_000 + 50_000 + 2_000_000_000
            ),
            new TestCase(
                List.of(Rank.NONE, Rank.NONE, Rank.NONE),
                LottoAmount.of(3000),
                Map.of(),
                0
            ),
            new TestCase(
                List.of(Rank.FIVE, Rank.FIVE_BONUS),
                LottoAmount.of(2000),
                Map.of(
                    Rank.FIVE, 1,
                    Rank.FIVE_BONUS, 1
                ),
                1_500_000 + 30_000_000
            ),
            new TestCase(
                List.of(Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.FIVE_BONUS, Rank.SIX, Rank.NONE),
                LottoAmount.of(6000),
                Map.of(
                    Rank.THREE, 1,
                    Rank.FOUR, 1,
                    Rank.FIVE, 1,
                    Rank.FIVE_BONUS, 1,
                    Rank.SIX, 1
                ),
                5_000 + 50_000 + 1_500_000 + 30_000_000 + 2_000_000_000
            )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideStatistics")
    void statistics_calculates_correctly(TestCase testCase) {
        List<Rank> results = testCase.getResults();
        Ranks ranks = Ranks.of(results);
        WinningStatistics stats = WinningStatistics.of(ranks.getRanksCount(), testCase.getSpent());

        Map<Rank, Integer> counts = stats.getResultCounts();
        for (Rank result : Rank.getValidValues()) {
            int expected = testCase.getExpectedCounts().getOrDefault(result, 0);
            assertEquals(expected, counts.getOrDefault(result, 0), result.name());
        }

        assertEquals(testCase.getExpectedPrize(), stats.totalPrize());
    }

    private static class TestCase {
        private final List<Rank> results;
        private final LottoAmount spent;
        private final Map<Rank, Integer> expectedCounts;
        private final int expectedPrize;

        private TestCase(List<Rank> results, LottoAmount spent, Map<Rank, Integer> expectedCounts, int expectedPrize) {
            this.results = results;
            this.spent = spent;
            this.expectedCounts = expectedCounts;
            this.expectedPrize = expectedPrize;
        }

        public List<Rank> getResults() {
            return results;
        }

        public LottoAmount getSpent() {
            return spent;
        }

        public Map<Rank, Integer> getExpectedCounts() {
            return expectedCounts;
        }

        public int getExpectedPrize() {
            return expectedPrize;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                "results=" + results +
                ", spent=" + spent.getValue() +
                ", expectedPrize=" + expectedPrize +
                '}';
        }
    }
}
