package domain;

import org.junit.jupiter.api.Test;

import domain.type.LottoRankAmount;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottoRankTest {

    @Test
    void firstRankTest() {
        LottoRankAmount rank = LottoRank.getRank(6, false);
        assertThat(rank, is(LottoRankAmount.FIRST));
    }

    @Test
    void secondRankTest() {
        LottoRankAmount rank = LottoRank.getRank(5, true);
        assertThat(rank, is(LottoRankAmount.SECOND));
    }

    @Test
    void thirdRankTest() {
        LottoRankAmount rank = LottoRank.getRank(5, false);
        assertThat(rank, is(LottoRankAmount.THIRD));
    }

    @Test
    void fourthRankTest() {
        LottoRankAmount rank = LottoRank.getRank(4, false);
        assertThat(rank, is(LottoRankAmount.FOURTH));
    }

    @Test
    void fifthRankTest() {
        LottoRankAmount rank = LottoRank.getRank(3, false);
        assertThat(rank, is(LottoRankAmount.FIFTH));
    }

    @Test
    void etcRankTest1() {
        LottoRankAmount rank = LottoRank.getRank(2, false);
        assertThat(rank, is(LottoRankAmount.ETC));
    }
}
