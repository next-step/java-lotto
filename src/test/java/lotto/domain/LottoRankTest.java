package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRankTest {


    @Test
    void 여섯개가_일치하면_1등값을_반환한다() {
        LottoRank given = LottoRank.valueOf(6, false);
        assertThat(given).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 다섯개가_일치하고_보너스볼이_일치하면_2등값을_반환한다() {
        LottoRank given = LottoRank.valueOf(5, true);
        assertThat(given).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 다섯개가_일치하고_보너스볼이_불일치하면_3등값을_반환한다() {
        LottoRank given = LottoRank.valueOf(5, false);
        assertThat(given).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 네개가_일치하면_4등값을_반환한다() {
        LottoRank given = LottoRank.valueOf(4, false);
        assertThat(given).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 세개가_일치하면_5등값을_반환한다() {
        LottoRank given = LottoRank.valueOf(3, false);
        assertThat(given).isEqualTo(LottoRank.FIFTH);
    }
}
