package domain;

import org.junit.jupiter.api.Test;

import domain.type.LottoRankResult;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

public class LottoRankTest {

    @Test
    void matchCountTest() {
        FirstPlaceLotto firstPlaceLotto = new FirstPlaceLotto("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6"));
        lotto.calculateLottoRank(firstPlaceLotto);

        System.out.println(lotto.getLottoNumbers());
        System.out.println(firstPlaceLotto.getLottoNumbers());
        System.out.println(firstPlaceLotto.getBonusLottoNumber());
        System.out.println(lotto.matchCount(firstPlaceLotto));

        assertThat(lotto.matchCount(firstPlaceLotto), is(6));
    }

    @Test
    void firstRankTest() {
        LottoRankResult rank = LottoRank.getRank(6, false);
        assertThat(rank, is(LottoRankResult.FIRST));
    }

    @Test
    void secondRankTest() {
        LottoRankResult rank = LottoRank.getRank(5, true);
        assertThat(rank, is(LottoRankResult.SECOND));
    }

    @Test
    void thirdRankTest() {
        LottoRankResult rank = LottoRank.getRank(5, false);
        assertThat(rank, is(LottoRankResult.THIRD));
    }

    @Test
    void fourthRankTest() {
        LottoRankResult rank = LottoRank.getRank(4, false);
        assertThat(rank, is(LottoRankResult.FOURTH));
    }

    @Test
    void fifthRankTest() {
        LottoRankResult rank = LottoRank.getRank(3, false);
        assertThat(rank, is(LottoRankResult.FIFTH));
    }

    @Test
    void etcRankTest1() {
        LottoRankResult rank = LottoRank.getRank(2, false);
        assertThat(rank, is(LottoRankResult.ETC));
    }
}
