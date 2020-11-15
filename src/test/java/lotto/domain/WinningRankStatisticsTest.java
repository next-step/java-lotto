package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankStatisticsTest {
    @Test
    @DisplayName("전체 로또 당첨 순위 별로 개수 모으기")
    void getWinningRankCount() {
        List<WinningRank> winningRankList = Arrays.asList(WinningRank.FIRST, WinningRank.FIRST, WinningRank.SECOND);
        WinningRanks winningRanks = new WinningRanks(winningRankList);

        WinningRankStatistics winningRankStatistics = new WinningRankStatistics(winningRanks);

        assertThat(winningRankStatistics.getWinningRankCount(WinningRank.FIRST)).isEqualTo(2);
        assertThat(winningRankStatistics.getWinningRankCount(WinningRank.SECOND)).isEqualTo(1);
    }
}
