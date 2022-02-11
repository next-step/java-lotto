package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 당첨번호가_일치하는_개수에_따라_순위를_확인() {
        Rank rank = Rank.getRank(4, true);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
}