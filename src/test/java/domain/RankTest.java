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

        //when
        Rank result1 = Rank.of(matchCount1);
        Rank result2 = Rank.of(matchCount2);

        //then
        assertThat(result1).isEqualTo(Rank.FIRST);
        assertThat(result2).isEqualTo(Rank.LOST);
    }
}