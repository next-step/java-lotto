package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    void 랭킹을_업데이트_한다() {
        Statistics statistics = new Statistics(2);
        MatchInfo matchInfo1 = new MatchInfo(5, true);
        MatchInfo matchInfo2 = new MatchInfo(3, false);
        Map<Rank, Integer> ranks = statistics.updateRanks(
            Arrays.asList(matchInfo1,matchInfo2)
        );
        assertThat(ranks.get(Rank.SECOND)).isEqualTo(1);
        assertThat(ranks.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(ranks.get(Rank.FIRST)).isEqualTo(0);
    }
}