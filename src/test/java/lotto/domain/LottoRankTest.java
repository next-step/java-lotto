package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    
    @Test
    void 일치_개수와_보너스볼로_등수를_찾을_수_있다() {
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(THIRD);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(FOURTH);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(FIFTH);
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(UNRANK);
    }
    
    @Test
    void 당첨_개수가_3개_미만일_경우_0원을_반환한다() {
        assertThat(LottoRank.valueOf(2, false).prizeMoney()).isEqualTo(0);
    }
}
