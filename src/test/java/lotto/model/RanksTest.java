package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RanksTest {

    @DisplayName("랭킹을 업데이트 한다")
    @Test
    void updateRanks() {
        Ranks ranks = new Ranks();
        MatchInfo matchInfo1 = new MatchInfo(5, true);
        MatchInfo matchInfo2 = new MatchInfo(3, false);
        Map<Rank, Integer> rankMap = ranks.updateRanks(
            Arrays.asList(matchInfo1, matchInfo2)
        );
        assertThat(rankMap.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankMap.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankMap.get(Rank.FIRST)).isEqualTo(0);
    }
}
