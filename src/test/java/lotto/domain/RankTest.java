package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @Test
    @DisplayName("6개 일치시 1등 상금 반환")
    public void getFistPrize() {

        // given
        int matchCount = 6;

        // when
        int prize = Rank.getRankingPrize(matchCount);

        // then
        assertThat(prize).isEqualTo(Rank.FIRST.getPrize());
    }

    @Test
    @DisplayName("5개 일치시 1등 상금 반환")
    public void getSecondPrize() {

        // given
        int matchCount = 5;

        // when
        int prize = Rank.getRankingPrize(matchCount);

        // then
        assertThat(prize).isEqualTo(Rank.SECOND.getPrize());
    }

    @Test
    @DisplayName("2개 일치시 0원 반환")
    public void getZeroPrizeTest() {

        // given
        int matchCount = 2;

        // when
        int prize = Rank.getRankingPrize(matchCount);

        // then
        assertThat(prize).isEqualTo(0);
    }
}
