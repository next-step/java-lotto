package lottogame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {
    public WinningStatistics winningStatistics;
    List<Rank> lottoRankList;

    @BeforeEach
    void set() {
        lottoRankList = new ArrayList<>();
    }

    @DisplayName("구매금액")
    @Test
    void purchaseAmount() {

        winningStatistics = new WinningStatistics(lottoRankList, 10);

        assertThat(winningStatistics.purchaseAmount()).isEqualTo(10000);

    }

    @DisplayName("당첨 금액")
    @Test
    void total_5() {
        lottoRankList.add(Rank.FIFTH);

        winningStatistics = new WinningStatistics(lottoRankList, 1);

        assertThat(winningStatistics.total()).isEqualTo(5000);

    }

    @DisplayName("당첨 금액")
    @Test
    void total() {
        lottoRankList.add(Rank.FIFTH);
        lottoRankList.add(Rank.FIRST);

        winningStatistics = new WinningStatistics(lottoRankList, 10);

        assertThat(winningStatistics.total()).isEqualTo(2000005000);

    }

    @DisplayName("수익률")
    @Test
    void yield() {
        lottoRankList.add(Rank.FIFTH);
        lottoRankList.add(Rank.FIRST);

        winningStatistics = new WinningStatistics(lottoRankList, 10);

        assertThat(winningStatistics.yield()).isEqualTo("200000.50");

    }


}
