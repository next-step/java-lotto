package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @Test
    @DisplayName("6개 일치 시 1등 반환")
    public void valueOf_AllMatch_ReturnFirst() {

        // given
        int matchCount = 6;

        // when
        Rank rank = Rank.valueOf(matchCount, false);

        //then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개와 보너스볼 일치 시 2등 반환")
    public void valueOf_FiveMatchAndMatchBonusBall_ReturnFirst() {

        // given
        int matchCount = 5;

        // when
        Rank rank = Rank.valueOf(matchCount, true);

        //then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개와 보너스볼 불일치 시 3등 반환")
    public void valueOf_FiveMatchAndNotMatchBonusBall_ReturnFirst() {

        // given
        int matchCount = 5;

        // when
        Rank rank = Rank.valueOf(matchCount, false);

        //then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("1개 일치 시 MISS 반환")
    public void valueOf_OneMatch_ReturnMiss() {

        // given
        int matchCount = 1;

        // when
        Rank rank = Rank.valueOf(matchCount, false);

        //then
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
