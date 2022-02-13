package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void 우승순위_조회(){
        // when
        Ranking ranking = Ranking.of(6, false);

        // then
        assertThat(ranking).isEqualTo(Ranking.ONE);
    }
}
