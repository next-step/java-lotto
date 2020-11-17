package lotto.service;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsServiceTest {

    private LottoStatisticsService lottoStatisticsService;

    @BeforeEach
    void setup() {
        lottoStatisticsService = new LottoStatisticsService();
    }

    @DisplayName("로또 리스트 당첨금액과 당첨금액율 계산 테스트")
    @ParameterizedTest(name = "[{index}] {0}의 당첨금은 {1}원 ({2})")
    @CsvSource(value = {
            "           FIRST,SECOND | 2001500000 | 1000750",
            "     SECOND,FOURTH,NONE |    1505000 | 501.66",
            "     FOURTH,FOURTH,NONE |      10000 | 3.33",
            "    NONE,NONE,NONE,NONE |          0 | 0 ",
            " FOURTH,NONE,NONE,NONE,NONE,NONE,NONE,NONE | 5000 | 0.62",
    }, delimiter = '|')
    void calculateProfit(String lottoRank, long expectedProfit, String expectedProfitRateString) {
        BigDecimal expectedProfitRate = new BigDecimal(expectedProfitRateString);

        List<LottoRank> lottoRanks = build(lottoRank);

        long profit = lottoStatisticsService.calculateProfit(lottoRanks);
        BigDecimal profitRate = lottoStatisticsService.calculateProfitRate(lottoRanks.size(), profit);

        assertThat(profit).isEqualByComparingTo(expectedProfit);
        assertThat(profitRate).isEqualByComparingTo(expectedProfitRate);
    }

    private List<LottoRank> build(String lottoRank) {
        return Arrays.stream(lottoRank.split(","))
                .map(LottoRank::valueOf)
                .collect(Collectors.toList());
    }
}
