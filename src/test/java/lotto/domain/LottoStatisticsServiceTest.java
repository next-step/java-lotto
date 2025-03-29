package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.dto.LottoStatisticsDTO;
import lotto.service.LottoStatisticsService;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsServiceTest {
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
        LottoStatisticsService stats = new LottoStatisticsService(statistics);
        List<LottoStatisticsDTO> report = stats.getLottoStatisticsDTOs();

        assertThat(report).containsExactly(
            new LottoStatisticsDTO(PrizeLevel.FIRST, 0),
            new LottoStatisticsDTO(PrizeLevel.SECOND, 0),
            new LottoStatisticsDTO(PrizeLevel.THIRD, 0),
            new LottoStatisticsDTO(PrizeLevel.FOURTH, 0)
        );
    }

    @Test
    @DisplayName("로또 당첨 통계 생성 테스트(여러 개)")
    void generateReport_다양한_결과() {
        statistics.put(PrizeLevel.FIRST, 1);
        statistics.put(PrizeLevel.SECOND, 2);
        statistics.put(PrizeLevel.THIRD, 3);
        LottoStatisticsService stats = new LottoStatisticsService(statistics);

        List<LottoStatisticsDTO> report = stats.getLottoStatisticsDTOs();

        assertThat(report).containsExactly(
            new LottoStatisticsDTO(PrizeLevel.FIRST, 1),
            new LottoStatisticsDTO(PrizeLevel.SECOND, 2),
            new LottoStatisticsDTO(PrizeLevel.THIRD, 3),
            new LottoStatisticsDTO(PrizeLevel.FOURTH, 0)
        );
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void profitRateTest() {
        statistics.put(PrizeLevel.THIRD, 2);
        statistics.put(PrizeLevel.FOURTH, 10);

        LottoStatisticsService stats = new LottoStatisticsService(statistics);
        int purchaseAmount = 100_000;

        double profitRate = stats.getProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(1.50);
    }
}
