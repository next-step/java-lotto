package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningPriceTest {

    @Test
    void enum_FIVE_반환_테스트() {
        Ranking ranking = Ranking.of(5, 0);
        Assertions.assertThat(ranking).isEqualTo(Ranking.Five);
    }

    @Test
    void enum_FIVE_BONUS_반환_테스트() {
        Ranking ranking = Ranking.of(5, 1);
        Assertions.assertThat(ranking).isEqualTo(Ranking.FiveWithBonus);
    }

    @Test
    void 로또_당첨_금액_테스트() {
        Ranking ranking = Ranking.of(5, 0);
        Assertions.assertThat(ranking.operate(1)).isEqualTo(1500000);
    }


}
