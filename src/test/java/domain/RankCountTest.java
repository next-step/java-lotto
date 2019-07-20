package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankCountTest {

    private RankCount rankCount;
    private LottoPaper lottoPaper;

    @Before
    public void setUp() {
        // given
        lottoPaper = new LottoPaper(Arrays.asList(
                LottoSet.newInstance(8, 21, 23, 41, 42, 43),
                LottoSet.newInstance(3, 5, 11, 16, 32, 38),
                LottoSet.newInstance(7, 11, 16, 35, 36, 44),
                LottoSet.newInstance(1, 8, 11, 31, 41, 42),
                LottoSet.newInstance(13, 14, 16, 38, 42, 45),
                LottoSet.newInstance(7, 11, 30, 40, 42, 43),
                LottoSet.newInstance(2, 13, 22, 32, 38, 45),
                LottoSet.newInstance(23, 25, 33, 36, 39, 41),
                LottoSet.newInstance(1, 3, 5, 14, 22, 45),
                LottoSet.newInstance(5, 9, 38, 41, 43, 44),
                LottoSet.newInstance(2, 8, 9, 18, 19, 21),
                LottoSet.newInstance(13, 14, 18, 21, 23, 35),
                LottoSet.newInstance(17, 21, 29, 37, 42, 45),
                LottoSet.newInstance(3, 8, 27, 30, 35, 44)));
        // when
        rankCount = new RankCount(lottoPaper, new WinningLotto(LottoSet.newInstance(1, 2, 3, 4, 5, 6), LottoNumber.of(44)));
    }

    @Test
    public void 수익률_일치() {
        // then
        assertThat(rankCount.calculateProfit()).isEqualTo(0.35);
    }

    @Test
    public void 매칭개수_일치() {
        // then
        assertThat(rankCount.getNumberOfRankCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankCount.getNumberOfRankCount(Rank.FIRST)).isEqualTo(0);
    }
}