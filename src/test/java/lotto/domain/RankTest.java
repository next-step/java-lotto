package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class RankTest {

    @Test
    void 일치갯수로_등수_생성() {
        Assertions.assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        Assertions.assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }

    @Test
    void 등수_목록_총_상금액_계산() {
        List<Rank> ranks = List.of(
            Rank.FIFTH,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS,
            Rank.MISS
        );

        Assertions.assertThat(Rank.sumPrize(ranks)).isEqualTo(BigDecimal.valueOf(5000));
    }

}