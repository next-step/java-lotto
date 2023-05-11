package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTypeTest {
 
    @Test
    void rankTypeTest_findRankType_4등() {
        assertThat(RankType.findRankType(3, false)).isEqualTo(RankType.FIFTH);
        assertThat(RankType.findRankType(3, true)).isEqualTo(RankType.FIFTH);
    }

    @Test
    void rankTypeTest_findRankType_not_match() {
        assertThat(RankType.findRankType(2, false)).isEqualTo(RankType.MISS);
        assertThat(RankType.findRankType(0, false)).isEqualTo(RankType.MISS);
    }

    @Test
    void rankTypeTest_findRankType_2등() {
        assertThat(RankType.findRankType(5, true)).isEqualTo(RankType.SECOND);
    }
    @Test
    void rankTypeTest_findRankType_3등() {
        assertThat(RankType.findRankType(5, false)).isEqualTo(RankType.THIRD);
    }
}