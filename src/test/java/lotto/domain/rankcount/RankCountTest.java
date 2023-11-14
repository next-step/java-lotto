package lotto.domain.rankcount;

import lotto.domain.lotto.LotteryRank;
import lotto.domain.rankcount.RankCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankCountTest {

    @DisplayName("인자로 받은 LotterRank가 자신의 LotteryRank와 같은 지 비교한다.")
    @Test
    void isEqualWithRank() {
        // given
        RankCount rankCount = new RankCount(LotteryRank.FIRST, 3);

        // when
        boolean result = rankCount.isEqualWithRank(LotteryRank.SECOND);

        // then
        assertThat(result).isFalse();
    }
}