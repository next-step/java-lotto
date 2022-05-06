package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @Test
    @DisplayName("순위 개수를 구하는 map 반환")
    void returnGroupByMap() {
        // given
        List<Rank> matchNumbers = List.of(
                Rank.FOURTH,
                Rank.FIRST,
                Rank.SECOND,
                Rank.FOURTH,
                Rank.FOURTH,
                Rank.THIRD,
                Rank.THIRD
        );
        // when
        List<RankResult> rankResults = Ranks.getRankResults(matchNumbers);

        // then
        assertThat(rankResults).containsExactly(
                new RankResult(Rank.FIRST, 1),
                new RankResult(Rank.SECOND, 1),
                new RankResult(Rank.THIRD, 2),
                new RankResult(Rank.FOURTH, 3),
                new RankResult(Rank.FIFTH, 0));
    }
}