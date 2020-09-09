package AutoLotto.domain.play;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static AutoLotto.utils.Constants.*;

class RankTest {

    @Test
    void canCreateRankOfMatch() {
        assertThat(Rank.matchOf(MATCH_COUNT_FIRST).rankMoney).isEqualTo(RANK_MONEY_FIRST);
        assertThat(Rank.matchOf(MATCH_COUNT_FOURTH).rankMoney).isEqualTo(RANK_MONEY_FOURTH);
        assertThat(Rank.matchOf(MATCH_COUNT_SIXTH).rankMoney).isEqualTo(ZERO_MONEY_SIXTH);
        assertThat(Rank.matchOf(MATCH_COUNT_FIRST)).isEqualTo(Rank.FIRST);
    }
}