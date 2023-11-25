package step3.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 조건에_맞는_Rank_찾기_2등_테스트() {
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 조건에_맞는_Rank_찾기_3등_테스트() {
        assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 조건에_맞는_Rank_찾기_4등_테스트() {
        assertThat(Rank.findRank(4, true)).isEqualTo(Rank.FOURTH);
    }
}
