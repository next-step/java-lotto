package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {
    @Test
    void rank_1등(){
        assertThat(Rank.getRankByMatchCount(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void rank_2등(){
        assertThat(Rank.getRankByMatchCount(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank_3등(){
        assertThat(Rank.getRankByMatchCount(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void rank_4등(){
        assertThat(Rank.getRankByMatchCount(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void rank_5등(){
        assertThat(Rank.getRankByMatchCount(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void rank_등수없음(){
        assertThat(Rank.getRankByMatchCount(2, false)).isEqualTo(Rank.MISS);
    }
}
