package step02Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.model.rank.Rank;
import step02.model.rank.Ranks;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    private Ranks ranks = new Ranks();

    @BeforeEach
    void setRanks() {
        ranks.addRanks(Rank.FIRST);
        ranks.addRanks(Rank.FIRST);
        ranks.addRanks(Rank.SECOND);
        ranks.addRanks(Rank.THIRD);
        ranks.addRanks(Rank.THIRD);
    }


    @Test
    @DisplayName("총 로또 rank 개수 리턴 테스트")
    void getNumberOfEachRank() {
        assertThat(ranks.getNumberOfEachRank(Rank.FIRST)).isEqualTo(2);
        assertThat(ranks.getNumberOfEachRank(Rank.SECOND)).isEqualTo(1);
        assertThat(ranks.getNumberOfEachRank(Rank.THIRD)).isEqualTo(2);
    }

    @Test
    void getMatchRankWithBonus() {
        assertThat(Rank.getMatchRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getMatchRank(5, false)).isEqualTo(Rank.THIRD);
    }
}
