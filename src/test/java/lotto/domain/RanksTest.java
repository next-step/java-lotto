package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class RanksTest {

    @Test
    @DisplayName("순위 개수를 구하는 map 반환")
    void returnGroupByMap() {
        // given
        List<Integer> matchNumbers = List.of(4, 4, 6, 5, 5, 4);
        // when
        Map<Rank, Integer> rankIntegerMap = Ranks.getGroupByMap(matchNumbers);
        // then
        assertThat(rankIntegerMap).containsExactly(
                entry(Rank.FIRST, 1),
                entry(Rank.SECOND, 2),
                entry(Rank.THIRD, 3),
                entry(Rank.FOURTH, 0));
    }


}