package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.vo.LottoStatisticsValue;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
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
        LottoStatistics stats = new LottoStatistics(statistics);
        List<LottoStatisticsValue> report = stats.getLottoStatisticsDTOs();

        assertThat(report).containsExactly(
            new LottoStatisticsValue(PrizeLevel.FIRST, 0),
            new LottoStatisticsValue(PrizeLevel.SECOND, 0),
            new LottoStatisticsValue(PrizeLevel.THIRD, 0),
            new LottoStatisticsValue(PrizeLevel.FOURTH, 0),
            new LottoStatisticsValue(PrizeLevel.FIFTH, 0)
        );
    }

    @Test
    @DisplayName("로또 당첨 통계 생성 테스트(여러 개)")
    void generateReport_다양한_결과() {
        statistics.put(PrizeLevel.FIRST, 1);
        statistics.put(PrizeLevel.THIRD, 2);
        statistics.put(PrizeLevel.FOURTH, 3);
        LottoStatistics stats = new LottoStatistics(statistics);

        List<LottoStatisticsValue> report = stats.getLottoStatisticsDTOs();

        assertThat(report).containsExactly(
            new LottoStatisticsValue(PrizeLevel.FIRST, 1),
            new LottoStatisticsValue(PrizeLevel.SECOND, 0),
            new LottoStatisticsValue(PrizeLevel.THIRD, 2),
            new LottoStatisticsValue(PrizeLevel.FOURTH, 3),
            new LottoStatisticsValue(PrizeLevel.FIFTH, 0)
        );
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void profitRateTest() {
        statistics.put(PrizeLevel.FOURTH, 2);
        statistics.put(PrizeLevel.FIFTH, 10);

        LottoStatistics stats = new LottoStatistics(statistics);
        int purchaseAmount = 100_000;

        double profitRate = stats.getProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(1.50);
    }
}
