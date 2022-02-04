package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankingTest {


    @Test
    void 우승순위_조회(){
        // given
        LottoResult lottoResult = new LottoResult(6, 0);

        // when
        Ranking ranking = Ranking.getRanking(lottoResult);

        // then
        assertThat(ranking).isEqualTo(Ranking.ONE);
    }

    @Test
    void 수익률_조회(){
        // given
        LottoResult lottoResult = new LottoResult(3, 0);
        int userBuyPrice = 500;

        // when
        double rewardRate = Ranking.getRewardRate(lottoResult, userBuyPrice);

        // then
        assertThat(rewardRate).isEqualTo(0.1);
    }
}