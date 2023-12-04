package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void 일치하는_수를_로또_등수로_변경_테스트() {
        Optional<Rank> rank = Rank.valueOf(6, false);
        Optional<Rank> rank2 = Rank.valueOf(5, true);

        assertThat(rank.get()).isEqualTo(Rank.FIRST);
        assertThat(rank2.get()).isEqualTo(Rank.SECOND);
    }

}
