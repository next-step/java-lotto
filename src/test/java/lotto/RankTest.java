package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void 당첨통계_4개일치_상금확인() {
        int matchCount = 4;
        Rank rank = Rank.of(matchCount, false);
        assertThat(rank.getWinningMoney()).isEqualTo(50000);
    }

}
