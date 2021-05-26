package lotto.statistics;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    @DisplayName(value = "보너스 번호가 match 되어 2등이면 SECOND를 반환한다")
    void second() {
        assertThat(Ranking.valueOf(5, true)).isEqualTo(Ranking.SECOND);
    }

    @Test
    @DisplayName(value = "보너스 번호는 match 되지 않고, 5개가 match 되면 3등을 반환한다")
    void third() {
        assertThat(Ranking.valueOf(5, false)).isEqualTo(Ranking.THIRD);
    }

    @Test
    @DisplayName(value = "match 당 랭킹 반환")
    void ranking() {
        assertThat(Ranking.valueOf(3, false)).isEqualTo(Ranking.FIFTH);
        assertThat(Ranking.valueOf(4, false)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.valueOf(6, false)).isEqualTo(Ranking.FIRST);
    }

}