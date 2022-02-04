package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void 우승순위_조회(){
        // when
        Ranking ranking = Ranking.getRanking(6, 0);

        // then
        assertThat(ranking).isEqualTo(Ranking.ONE);
    }

    @Test
    void 수익률_조회(){
        // given
        int userBuyPrice = 500;

        // when
        double rewardRate = Ranking.getRewardRate(3,0, userBuyPrice);

        // then
        assertThat(rewardRate).isEqualTo(0.1);
    }
}