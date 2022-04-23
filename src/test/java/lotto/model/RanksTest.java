package lotto.model;

import lotto.model.rank.Rank;
import lotto.model.rank.RankResult;
import lotto.model.rank.Ranks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @Test
    @DisplayName("로또 결과를 그룹핑한다")
    void groupBy() {
        Ranks ranks = new Ranks(List.of(Rank.FOURTH, Rank.FOURTH));
        List<RankResult> rankResults = ranks.groupBy();
        assertThat(rankResults).contains(new RankResult(Rank.FOURTH, 2));
    }

}