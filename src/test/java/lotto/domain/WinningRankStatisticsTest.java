package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.domain.MoneyLottoMapper.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class WinningRankStatisticsTest {
    WinningRankStatistics winningRankStatistics;

    @BeforeEach
    void setUp() {
        List<WinningRank> winningRankList = Arrays.asList(WinningRank.FIRST, WinningRank.FIRST, WinningRank.SECOND);
        WinningRanks winningRanks = new WinningRanks(winningRankList);

        winningRankStatistics = new WinningRankStatistics(winningRanks);
    }

    @Test
    @DisplayName("수익률 계산하기")
    void getYield() {
        BigDecimal totalLottoPrice = new BigDecimal(LOTTO_PRICE * 3);
        BigDecimal priceEarned = new BigDecimal(WinningRank.FIRST.getPrice() * 2 + WinningRank.SECOND.getPrice() * 1);
        BigDecimal expectedYield = priceEarned.divide(totalLottoPrice, winningRankStatistics.SCALE, winningRankStatistics.ROUNDING_MODE);
        assertThat(winningRankStatistics.calculateYield()).isEqualTo(expectedYield);
    }

    @Test
    @DisplayName("전체 로또 당첨 순위 별로 개수 모으기")
    void getWinningRankCount() {
        Map<WinningRank, Integer> counter = winningRankStatistics.getCounter();

        assertThat(counter)
                .containsEntry(WinningRank.FIRST, 2)
                .containsEntry(WinningRank.SECOND, 1);
    }
}
