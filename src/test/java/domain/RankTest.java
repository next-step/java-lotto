package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("일치하는 번호와 보너스 번호 포함 여부를 정상적으로 해석한다.")
    void resolveRank() {
        /* given & when */
        Rank second = Rank.resolveRank(5, true);
        Rank third = Rank.resolveRank(5, false);

        /* then */
        assertThat(second).isEqualTo(Rank.SECOND);
        assertThat(third).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("여러 등수의 상금 합계를 구한다.")
    void calculatePrize() {
        /* given */
        Map<Rank, Long> statistic = new HashMap<>() {{
            put(Rank.THIRD, 1L);
            put(Rank.FIFTH, 2L);
            put(Rank.NONE, 5L);
        }};
        long thirdPrize = 1_500_000L;
        long fifthPrize = 5_000L;

        /* when */
        long prizeSum = Rank.calculatePrize(statistic);

        /* then */
        assertThat(prizeSum).isEqualTo(thirdPrize + fifthPrize * 2L);
    }

}
