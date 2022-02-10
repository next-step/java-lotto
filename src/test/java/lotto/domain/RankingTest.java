package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingTest {


    @Test
    void 우승순위_조회() {
        Assertions.assertAll(
            () -> assertThat(Ranking.judgeRanking(6, false)).isEqualTo(Ranking.FIRST),
            () -> assertThat(Ranking.judgeRanking(6, true)).isEqualTo(Ranking.FIRST),
            () -> assertThat(Ranking.judgeRanking(5, true)).isEqualTo(Ranking.SECOND),
            () -> assertThat(Ranking.judgeRanking(5, false)).isEqualTo(Ranking.THIRD),
            () -> assertThat(Ranking.judgeRanking(4, true)).isEqualTo(Ranking.FOURTH),
            () -> assertThat(Ranking.judgeRanking(4, false)).isEqualTo(Ranking.FOURTH)
        );
    }

    @Test
    void 등수별_상금_계산() {
        assertThat(Ranking.FOURTH.multiplyCountAndWinnerPrice(3)).isEqualTo(150000);
    }
}
