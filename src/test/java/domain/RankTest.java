package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("3개 미만 맞췄을 때")
    void getFailRank() {
        assertThat(Rank.getRank(2, false)).isEqualTo(Rank.FAIL);
    }

    @Test
    @DisplayName("보너스 못맞춰서 3등일때")
    void getThirdRank() {
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("보너스 맞춰서 2등일때")
    void getSecondRank() {
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
    }

}