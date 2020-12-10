package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("일치 번호에 해당하는 Rank 확인")
    public void get_rank_by_matching_score() {
        Rank rank = Rank.getRankByMatchingScore(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
}
