package lotto.domain.rankcount;

import lotto.domain.lotto.LotteryRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.lotto.LotteryRank.*;
import static org.assertj.core.api.Assertions.*;

class RankCountGroupTest {

    @DisplayName("인자로 받은 LotteryRank에 해당하는 로또 당첨 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"FIRST,1", "SECOND,2", "THIRD,0", "FOURTH,0"})
    void findWinningCountBy(LotteryRank rank, int expectedWinningCount) {
        // given
        Map<LotteryRank, Long> rankCountMap = new HashMap<>();
        rankCountMap.put(FIRST, 1L);
        rankCountMap.put(SECOND, 2L);

        RankCountGroup rankCountGroup = new RankCountGroup(rankCountMap);

        // when
        long winningCount = rankCountGroup.findWinningCountBy(rank);

        // then
        assertThat(winningCount).isEqualTo(expectedWinningCount);
    }
}