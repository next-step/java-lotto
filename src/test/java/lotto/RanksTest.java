package lotto;

import lotto.domain.Ranks;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @Test
    void ranksCountTest() {
        List<Rank> ranksInit = new ArrayList<>();
        ranksInit.add(Rank.FIRST);
        ranksInit.add(Rank.THIRD);
        ranksInit.add(Rank.FIRST);
        ranksInit.add(Rank.FIRST);
//        Ranks ranks = new Ranks(ranksInit);
//        assertThat(ranks.getRanks()).hasSize(4);
//        assertThat(ranks.getRanks()).contains(Rank.FIRST);
    }
}
