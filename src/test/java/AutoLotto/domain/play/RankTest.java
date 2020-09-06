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

    @Test
    void canCreateBuzzMoney() {
        List<Integer> matchCountList1 = Arrays.asList(1,0,2,0,6);
        assertThat(Rank.createBuzzMoney(matchCountList1)).isEqualTo(RANK_MONEY_FIRST);

        List<Integer> matchCountList2 = Arrays.asList(5,3,0,1);
        assertThat(Rank.createBuzzMoney(matchCountList2)).isEqualTo(RANK_MONEY_SECOND + RANK_MONEY_FOURTH);

        List<Integer> matchCountList3 = Arrays.asList(4,0,6,4);
        assertThat(Rank.createBuzzMoney(matchCountList3)).isEqualTo(RANK_MONEY_THIRD * 2 + RANK_MONEY_FIRST);

    }
}