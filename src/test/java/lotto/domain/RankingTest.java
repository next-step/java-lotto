package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankingTest {


    @Test
    void 우승순위_조회() {
        // given
        LottoResult lottoResult = new LottoResult(6, false);

        // when
        Ranking ranking = Ranking.judgeRanking(lottoResult);

        // then
        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    void 등수별_상금_계산() {
        assertThat(Ranking.FOURTH.multiplyCountAndWinnerPrice(3)).isEqualTo(150000);
    }
}
