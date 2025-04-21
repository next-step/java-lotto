package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void testRank() {
        // given
        int countOfMatch = 6;
        boolean matchBonus = false;
        LottoMatch match = new LottoMatch(countOfMatch, matchBonus);

         // when
        Rank rank = Rank.valueOf(match);

        // then
        int firstPlaceWinningPrice = Rank.FIRST.getWinningMoney();
        assertThat(rank.getCountOfMatch()).isEqualTo(countOfMatch);
        assertThat(rank.getWinningMoney()).isEqualTo(firstPlaceWinningPrice);
    }
}
