package io.mwkwon.lotto.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RankTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void matchRank_1등(boolean isMatchBonus) {
        Rank rank = Rank.matchRank(6, isMatchBonus);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void matchRank_2등() {
        Rank rank = Rank.matchRank(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void matchRank_3등() {
        Rank rank = Rank.matchRank(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void matchRank_4등(boolean isMatchBonus) {
        Rank rank = Rank.matchRank(4, isMatchBonus);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void matchRank_5등(boolean isMatchBonus) {
        Rank rank = Rank.matchRank(3, isMatchBonus);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:true", "2:false", "1:true", "1:false", "0:true", "0:false"}, delimiter = ':')
    void matchRank_미당첨(long matchCount, boolean isMatchBonus) {
        Rank rank = Rank.matchRank(matchCount, isMatchBonus);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, 7})
    void matchRank_inValid(long matchCount) {
        assertThatThrownBy(() -> Rank.matchRank(matchCount, true))
                .isInstanceOf(IllegalArgumentException.class);
    }


}