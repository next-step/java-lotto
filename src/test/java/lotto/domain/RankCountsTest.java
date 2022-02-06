package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankCountsTest {

    @DisplayName("등수별 당첨 수를 받아 객체를 생성한다. - 정상 생성")
    @Test
    void Given_등수별_당첨_수_When_객체_생성_Then_등수별_당첨_수를_잘_가지고_있음() {
        // given
        final Map<LottoRank, Integer> expected = new HashMap<LottoRank, Integer>() {
            {
                put(LottoRank.FIRST, 0);
                put(LottoRank.SECOND, 1);
                put(LottoRank.THIRD, 2);
                put(LottoRank.FOURTH, 0);
                put(LottoRank.FIFTH, 0);
            }
        };

        // when
        final RankCounts rankCounts = new RankCounts(expected);

        // then
        assertThat(rankCounts.get()).isEqualTo(expected);
    }
}