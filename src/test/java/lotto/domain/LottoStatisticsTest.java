package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @DisplayName("LottoStatistics 생성 테스트")
    @Test
    void of() {
        List<LottoRank> lottoRanks = Arrays.asList(
                LottoRank.FOURTH,
                LottoRank.FOURTH,
                LottoRank.NONE
        );

        assertThat(new LottoStatistics(lottoRanks))
                .isEqualToComparingFieldByField(new LottoStatistics(lottoRanks));
    }

    @DisplayName("로또 당첨금액과 당첨금액율 계산 테스트")
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

        LottoStatistics lottoStatistics = new LottoStatistics(build(lottoRank));

        long profit = lottoStatistics.calculateProfit();
        BigDecimal profitRate = lottoStatistics.calculateProfitRate();

        assertThat(profit).isEqualByComparingTo(expectedProfit);
        assertThat(profitRate).isEqualByComparingTo(expectedProfitRate);
    }

    private List<LottoRank> build(String lottoRank) {
        return Arrays.stream(lottoRank.split(","))
                .map(LottoRank::valueOf)
                .collect(Collectors.toList());
    }
}
