import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidateRankTest {
    @Test
    void create() {
        Lotto winning = new Lotto("1,2,3,4,5,6");
        Lotto candidate_1 = new Lotto("1,2,3,4,5,6");
        Lotto candidate_2 = new Lotto("1,2,3,4,5,16");
        Lotto candidate_3 = new Lotto("1,2,3,4,15,16");
        Lotto candidate_4 = new Lotto("1,2,3,14,15,16");

        assertThat(new CandidateRank(winning, candidate_1).is(Rank.FIRST)).isTrue();
        // TODO: Rank 2 is bonus
        assertThat(new CandidateRank(winning, candidate_2).is(Rank.THIRD)).isTrue();
        assertThat(new CandidateRank(winning, candidate_3).is(Rank.FOURTH)).isTrue();
        assertThat(new CandidateRank(winning, candidate_4).is(Rank.FIFTH)).isTrue();
    }
}
