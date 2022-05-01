package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class RanksTest {

    @ParameterizedTest
    @CsvSource(value = {"10000L:100d", "20000L:200d"}, delimiter = ':')
    @DisplayName("수익률 반환")
    void returnProfitRatio(long money, double ratio) {
        // given
        Ranks ranks = new Ranks(List.of(Rank.THIRD, Rank.THIRD));
        // when
        double profitRatio = ranks.getProfitRatio(BigDecimal.valueOf(money));
        // then
        assertThat(profitRatio).isEqualTo(ratio);
    }

    @Test
    @DisplayName("순위 개수를 구하는 map 반환")
    void returnGroupByMap() {
        // given
        Ranks ranks = new Ranks(List.of(Rank.THIRD, Rank.THIRD, Rank.FIRST, Rank.SECOND,Rank.SECOND, Rank.THIRD));
        // when
        Map<Rank, Integer> rankIntegerMap = ranks.groupBy();
        System.out.println("rankIntegerMap = " + rankIntegerMap);
        assertThat(rankIntegerMap).containsExactly(
                entry(Rank.FIRST, 1),
                entry(Rank.SECOND, 2),
                entry(Rank.THIRD, 3),
                entry(Rank.FOURTH, 0));
    }

}