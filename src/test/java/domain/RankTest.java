package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("3개 이하 맞췄을 때")
    void getFailRank() {
        Lotto lotto = new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(Rank.getRank(2, lotto, 4)).isEqualTo(Rank.FAIL);
    }

    @Test
    @DisplayName("보너스 못맞춰서 3등일때")
    void getThirdRank() {
        Lotto lotto = new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(Rank.getRank(5, lotto, 7)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("보너스 맞춰서 2등일때")
    void getSecondRank() {
        Lotto lotto = new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(Rank.getRank(5, lotto, 6)).isEqualTo(Rank.SECOND);
    }

}