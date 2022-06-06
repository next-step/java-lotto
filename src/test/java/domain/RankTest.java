package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void of() {
        //given
        int matchCount1 = 6;
        int matchCount2 = 1;
        boolean bonusMatch = false;

        //when
        Rank result1 = Rank.of(matchCount1, bonusMatch);
        Rank result2 = Rank.of(matchCount2, bonusMatch);

        //then
        assertThat(result1).isEqualTo(Rank.FIRST);
        assertThat(result2).isEqualTo(Rank.LOST);
    }

    @Test
    void ofSecond() {
        //given
        int matchCount = 5;

        //when
        Rank result1 = Rank.of(matchCount, true);
        Rank result2 = Rank.of(matchCount, false);

        //then
        assertThat(result1).isEqualTo(Rank.SECOND);
        assertThat(result2).isEqualTo(Rank.THIRD);
    }
}