package lotto.domain.prize;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

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