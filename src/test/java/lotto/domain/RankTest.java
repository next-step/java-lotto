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

    @Test
    @DisplayName("6개 일치 시 1등 반환")
    public void valueOf_AllMatch_ReturnFirst() {

        // given
        int matchCount = 6;
        boolean matchBonus = true;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        //then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개와 보너스볼 일치 시 2등 반환")
    public void valueOf_FiveMatchAndMatchBonusBall_ReturnFirst() {

        // given
        int matchCount = 5;
        boolean matchBonus = true;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        //then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개와 보너스볼 불일치 시 3등 반환")
    public void valueOf_FiveMatchAndNotMatchBonusBall_ReturnFirst() {

        // given
        int matchCount = 5;
        boolean matchBonus = false;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        //then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("1개 일치 시 MISS 반환")
    public void valueOf_OneMatch_ReturnMiss() {

        // given
        int matchCount = 1;
        boolean matchBonus = true;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        //then
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
