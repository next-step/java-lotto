package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("3개 미만 맞췄을 때")
    void getFailRank() {
        assertThat(Rank.getRank(2)).isEqualTo(Rank.FAIL);
    }

    @Test
    @DisplayName("보너스 못맞춰서 3등일때")
    void getThirdRank() {
        assertThat(Rank.getBonusRank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("보너스 맞춰서 2등일때")
    void getSecondRank() {
        assertThat(Rank.getBonusRank(5, true)).isEqualTo(Rank.SECOND);
    }

}