package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingTest {


    @Test
    void 우승순위_조회() {
        // given
        LottoResult sixWithFalse = new LottoResult(6, false);
        LottoResult sixWithTrue = new LottoResult(6, true);
        LottoResult fiveWithTrue = new LottoResult(5, true);
        LottoResult fiveWithFalse = new LottoResult(5, false);
        LottoResult fourWithTrue = new LottoResult(4, true);
        LottoResult fourWithFalse = new LottoResult(4, false);

        // then
        Assertions.assertAll(
            () -> assertThat(Ranking.judgeRanking(sixWithFalse)).isEqualTo(Ranking.FIRST),
            () -> assertThat(Ranking.judgeRanking(sixWithTrue)).isEqualTo(Ranking.FIRST),
            () -> assertThat(Ranking.judgeRanking(fiveWithTrue)).isEqualTo(Ranking.SECOND),
            () -> assertThat(Ranking.judgeRanking(fiveWithFalse)).isEqualTo(Ranking.THIRD),
            () -> assertThat(Ranking.judgeRanking(fourWithTrue)).isEqualTo(Ranking.FOURTH),
            () -> assertThat(Ranking.judgeRanking(fourWithFalse)).isEqualTo(Ranking.FOURTH)
        );
    }

    @Test
    void 등수별_상금_계산() {
        assertThat(Ranking.FOURTH.multiplyCountAndWinnerPrice(3)).isEqualTo(150000);
    }
}
