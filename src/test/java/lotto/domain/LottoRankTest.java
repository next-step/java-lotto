package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("상금이 있는 로또 등수 목록을 높은 등수 순으로 가져와야 한다.")
    @Test
    void getRewardRanks() {
        assertThat(LottoRank.getRewardRanks())
                .containsExactly(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH);
    }

    @DisplayName("상금이 있는 로또 등수 목록을 낮은 등수 순으로 가져와야 한다.")
    @Test
    void getRewardRanksReversed() {
        assertThat(LottoRank.getRewardRanksReversed())
                .containsExactly(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    }

}
