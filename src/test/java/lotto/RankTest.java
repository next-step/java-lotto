package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Rank;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 랭크를_잘_받는지_확인() {
        Rank rank = Rank.getRank(4, true);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
}