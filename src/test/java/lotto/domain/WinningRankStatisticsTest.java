package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankStatisticsTest {
    @Test
    @DisplayName("전체 로또 당첨 순위 별로 개수 모으기")
    void getWinningRankCount() {
        List<WinningRank> winningRankList = Arrays.asList(WinningRank.FIRST, WinningRank.FIRST, WinningRank.SECOND);
        WinningRanks winningRanks = new WinningRanks(winningRankList);

        Map<WinningRank, Integer> counter = new WinningRankStatistics(winningRanks).getCounter();

        assertThat(counter)
                .containsEntry(WinningRank.FIRST, 2)
                .containsEntry(WinningRank.SECOND, 1);
    }
}
