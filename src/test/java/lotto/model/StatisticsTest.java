package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    void 랭킹을_업데이트_한다() {
        Statistics statistics = new Statistics(2);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), 5, true);
        Lotto lotto2 = new Lotto(Arrays.asList(2, 4, 6, 8, 10, 12), 3, false);
        Map<Rank, Integer> ranks = statistics.updateRanks(
            Arrays.asList(lotto1, lotto2)
        );
        assertThat(ranks.get(Rank.SECOND)).isEqualTo(1);
        assertThat(ranks.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(ranks.get(Rank.FIRST)).isEqualTo(0);
    }
}