import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidatesTest {
    @Test
    void create(){
        assertThat(new Candidates().size()).isEqualTo(0);
    }

    @Test
    void calc_ranks() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);

        Candidates candidates = new Candidates();
        candidates.add(new Lotto(1, 2, 3, 4, 5, 6)); // 1
        candidates.add(new Lotto(1, 2, 3, 4, 5, 16)); // 3
        candidates.add(new Lotto(1, 2, 3, 4, 15, 16)); // 4
        candidates.add(new Lotto(1, 2, 3, 14, 15, 16)); // 5
        candidates.add(new Lotto(1, 2, 13, 14, 15, 16)); // unranked

        CandidateRanks ranks = candidates.calcRanks(winning);

        assertThat(ranks.countFirst()).isEqualTo(1);
        assertThat(ranks.countThird()).isEqualTo(1);
        assertThat(ranks.countFourth()).isEqualTo(1);
        assertThat(ranks.countFifth()).isEqualTo(1);
    }
}
