package lotto.domain.prize;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void 일치하는_수를_로또_등수로_변경한다() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);

        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
    }


    @Test
    void 상금을_계산한다() {
        int matchCount = 1;
        int[] price = new int[]{5_000, 50_000, 1_500_000, 2_000_000_000};
        int i = 0;
        for (Rank rank : Rank.values()) {
            int prizeMoney = rank.calculateTotalPrice(matchCount);
            assertThat(prizeMoney).isEqualTo(matchCount * price[i++]);
        }
    }

}