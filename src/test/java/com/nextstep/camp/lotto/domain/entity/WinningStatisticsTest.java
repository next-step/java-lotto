package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningStatisticsTest {

    static Stream<TestCase> provideStatistics() {
        return Stream.of(
            new TestCase(
                List.of(MatchResult.THREE, MatchResult.THREE, MatchResult.FOUR, MatchResult.SIX, MatchResult.NONE),
                LottoAmount.of(5000),
                Map.of(
                    MatchResult.THREE, 2,
                    MatchResult.FOUR, 1,
                    MatchResult.FIVE, 0,
                    MatchResult.FIVE_BONUS, 0,
                    MatchResult.SIX, 1
                ),
                2 * 5_000 + 50_000 + 2_000_000_000
            ),
            new TestCase(
                List.of(MatchResult.NONE, MatchResult.NONE, MatchResult.NONE),
                LottoAmount.of(3000),
                Map.of(),
                0
            ),
            new TestCase(
                List.of(MatchResult.FIVE, MatchResult.FIVE_BONUS),
                LottoAmount.of(2000),
                Map.of(
                    MatchResult.FIVE, 1,
                    MatchResult.FIVE_BONUS, 1
                ),
                1_500_000 + 30_000_000
            ),
            new TestCase(
                List.of(MatchResult.THREE, MatchResult.FOUR, MatchResult.FIVE, MatchResult.FIVE_BONUS, MatchResult.SIX, MatchResult.NONE),
                LottoAmount.of(6000),
                Map.of(
                    MatchResult.THREE, 1,
                    MatchResult.FOUR, 1,
                    MatchResult.FIVE, 1,
                    MatchResult.FIVE_BONUS, 1,
                    MatchResult.SIX, 1
                ),
                5_000 + 50_000 + 1_500_000 + 30_000_000 + 2_000_000_000
            )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideStatistics")
    void statistics_calculates_correctly(TestCase testCase) {
        WinningStatistics stats = WinningStatistics.of(testCase.getResults(), testCase.getSpent());

        Map<MatchResult, Integer> counts = stats.getResultCounts();
        for (MatchResult result : MatchResult.getValidValues()) {
            int expected = testCase.getExpectedCounts().getOrDefault(result, 0);
            assertEquals(expected, counts.getOrDefault(result, 0), result.name());
        }

        assertEquals(testCase.getExpectedPrize(), stats.totalPrize());
    }

    private static class TestCase {
        private final List<MatchResult> results;
        private final LottoAmount spent;
        private final Map<MatchResult, Integer> expectedCounts;
        private final int expectedPrize;

        private TestCase(List<MatchResult> results, LottoAmount spent, Map<MatchResult, Integer> expectedCounts, int expectedPrize) {
            this.results = results;
            this.spent = spent;
            this.expectedCounts = expectedCounts;
            this.expectedPrize = expectedPrize;
        }

        public List<MatchResult> getResults() {
            return results;
        }

        public LottoAmount getSpent() {
            return spent;
        }

        public Map<MatchResult, Integer> getExpectedCounts() {
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
