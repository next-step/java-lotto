package lotto;

import lotto.service.LottoRank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRankTest {

    @Test
    public void 로또_등수_결정() {
        assertThat(LottoRank.determineRank(5, true)).isEqualTo(2);
        assertThat(LottoRank.determineRank(5, false)).isEqualTo(3);
        assertThat(LottoRank.determineRank(3, true)).isEqualTo(0);
        assertThat(LottoRank.determineRank(4, true)).isEqualTo(5);
    }
}
