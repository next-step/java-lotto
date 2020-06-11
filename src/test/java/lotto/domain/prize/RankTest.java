package lotto.domain.prize;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"6,true,FIRST", "5, true, SECOND", "5, false, THIRD",
            "3, true, FIFTH", "2, true, MISS", "1, false, MISS"})
    void 일치하는_수를_로또_등수로_변경한다(int countOfMatch, boolean matchBonus, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(rank);
    }


    @Test
    void 상금을_계산한다() {
        int matchCount = 1;
        int[] price = new int[]{0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
        int i = 0;
        for (Rank rank : Rank.values()) {
            int prizeMoney = rank.calculateTotalPrice(matchCount);
            assertThat(prizeMoney).isEqualTo(matchCount * price[i++]);
        }
    }

}
