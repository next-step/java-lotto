import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;
    private List<Lotto> lottos;

    @Before
    public void setUp() {
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)),
                new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)),
                new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)),
                new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)),
                new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)),
                new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44)));
        lottoResult = new LottoResult(lottos, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 44);

    }

    @Test
    public void 수익률_일치() {
        assertThat(lottoResult.getProfit()).isEqualTo(0.35);
    }

    @Test
    public void 매칭개수_일치() {
        assertThat(lottoResult.getMatchNumber(Rank.FIFTH)).isEqualTo(1);
        assertThat(lottoResult.getMatchNumber(Rank.FIRST)).isEqualTo(0);
    }
}