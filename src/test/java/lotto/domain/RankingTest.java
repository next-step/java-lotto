package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void enum_FIVE_반환_테스트() {
        Ranking ranking = Ranking.of(5, 0);
        Assertions.assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @Test
    void enum_FIVE_BONUS_반환_테스트() {
        Ranking ranking = Ranking.of(5, 1);
        Assertions.assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Test
    void 로또_당첨_금액_테스트() {
        Ranking ranking = Ranking.of(5, 0);
        ranking.addWinningCount();
        Assertions.assertThat(ranking.operate()).isEqualTo(1500000);
    }


}
