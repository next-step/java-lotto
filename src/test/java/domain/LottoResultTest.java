package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoResultTest {
    private LottoResult lottoResult;
    private List<LottoSet> lottoPaper;

    @Before
    public void setUp() {
        // given
        lottoPaper = Arrays.asList(
                new LottoSet(8, 21, 23, 41, 42, 43),
                new LottoSet(3, 5, 11, 16, 32, 38),
                new LottoSet(7, 11, 16, 35, 36, 44),
                new LottoSet(1, 8, 11, 31, 41, 42),
                new LottoSet(13, 14, 16, 38, 42, 45),
                new LottoSet(7, 11, 30, 40, 42, 43),
                new LottoSet(2, 13, 22, 32, 38, 45),
                new LottoSet(23, 25, 33, 36, 39, 41),
                new LottoSet(1, 3, 5, 14, 22, 45),
                new LottoSet(5, 9, 38, 41, 43, 44),
                new LottoSet(2, 8, 9, 18, 19, 21),
                new LottoSet(13, 14, 18, 21, 23, 35),
                new LottoSet(17, 21, 29, 37, 42, 45),
                new LottoSet(3, 8, 27, 30, 35, 44));
        // when
        lottoResult = new LottoResult(lottoPaper, new WinningLotto(new LottoSet(1, 2, 3, 4, 5, 6), new LottoNumber(44)));
    }

    @Test
    public void 수익률_일치() {
        // then
        assertThat(lottoResult.getProfit()).isEqualTo(0.35);
    }

    @Test
    public void 매칭개수_일치() {
        // then
        assertThat(lottoResult.getLottoRankCount(Rank.FIFTH)).isEqualTo(1);
        assertThat(lottoResult.getLottoRankCount(Rank.FIRST)).isEqualTo(0);
    }
}