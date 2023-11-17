package lotto.domain.rankcount;

import lotto.domain.lotto.LotteryRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RankCountGroupTest {

    @DisplayName("인자로 받은 LotteryRank에 해당하는 로또 당첨 개수를 반환한다.")
    @Test
    void findWinningCountBy() {
        // given
        RankCount firstCount = new RankCount(LotteryRank.FIRST, 1);
        RankCount secondCount = new RankCount(LotteryRank.FIRST, 2);
        RankCountGroup rankCountGroup = new RankCountGroup(List.of(firstCount, secondCount));

        // when
        LotteryRank rank = LotteryRank.FIRST;
        long winningCount = rankCountGroup.findWinningCountBy(rank);

        // then
        assertThat(winningCount).isEqualTo(1);
    }
}