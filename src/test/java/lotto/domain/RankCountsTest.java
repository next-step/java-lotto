package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankCountsTest {

    @DisplayName("생성 테스트")
    @Test
    void 생성자() {
        // given
        Map<LottoRank, Integer> expected = new HashMap<LottoRank, Integer>() {
            {
                put(LottoRank.FIRST, 0);
                put(LottoRank.SECOND, 1);
                put(LottoRank.THIRD, 2);
                put(LottoRank.FOURTH, 0);
                put(LottoRank.FIFTH, 0);
            }
        };

        // when
        RankCounts rankCounts = new RankCounts(expected);

        // then
        assertThat(rankCounts.get()).isEqualTo(expected);
    }
}