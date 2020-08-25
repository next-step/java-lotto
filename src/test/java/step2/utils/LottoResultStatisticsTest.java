package step2.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.RankPrice;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultStatisticsTest {
    @Test
    @DisplayName("로또 금액 통계")
    public void getWinningPriceDetails() {
        LottoResultStatistics statistics = new LottoResultStatistics(new int[] {0, 3, 5, 6, 3, 4, 6});
        assertThat(statistics.getWinningPriceDetails()).containsKeys(RankPrice.FIRST_PLACE);
    }

    @Test
    @DisplayName("로또 총 수익률")
    void getFinalProfit() {
        LottoResultStatistics statistics = new LottoResultStatistics(new int[] {0, 0, 0, 3, 0, 0});

        assertThat(statistics.getFinalProfit(14000)).isEqualTo(0.36);
    }
}
