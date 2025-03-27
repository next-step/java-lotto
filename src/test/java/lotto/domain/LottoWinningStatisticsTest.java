package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningStatisticsTest {
    private Map<PrizeLevel, Integer> statistics;

    @BeforeEach
    void setup() {
        statistics = new EnumMap<>(PrizeLevel.class);

        for (PrizeLevel level : PrizeLevel.values()) {
            statistics.put(level, 0);
        }
    }

    @Test
    @DisplayName("로또 당첨 통계 생성 테스트(0개)")
    void generateReportTest_0개() {
        LottoWinningStatistics stats = new LottoWinningStatistics(statistics);
        List<String> report = stats.generateFormattedReport();

        assertThat(report).containsExactly(
            "6개 일치 (2000000000원) - 0개",
            "5개 일치 (1500000원) - 0개",
            "4개 일치 (50000원) - 0개",
            "3개 일치 (5000원) - 0개"
        );
    }

    @Test
    @DisplayName("로또 당첨 통계 생성 테스트(여러 개)")
    void generateReport_다양한_결과() {
        statistics.put(PrizeLevel.FIRST, 1);
        statistics.put(PrizeLevel.SECOND, 2);
        statistics.put(PrizeLevel.THIRD, 3);
        LottoWinningStatistics stats = new LottoWinningStatistics(statistics);

        List<String> report = stats.generateFormattedReport();

        assertThat(report).containsExactly(
            "6개 일치 (2000000000원) - 1개",
            "5개 일치 (1500000원) - 2개",
            "4개 일치 (50000원) - 3개",
            "3개 일치 (5000원) - 0개"
        );
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void profitRateTest() {
        statistics.put(PrizeLevel.THIRD, 2);
        statistics.put(PrizeLevel.FOURTH, 10);

        LottoWinningStatistics stats = new LottoWinningStatistics(statistics);
        int purchaseAmount = 100_000;

        double profitRate = stats.getProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(1.50);
    }
}
