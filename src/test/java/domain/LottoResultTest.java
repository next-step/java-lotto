package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @Before
    public void initLottoResult() {
        LottoNumbers firstLotto = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNumbers secondLotto = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(8)));
        LottoNumbers thirdLotto = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(12)));
        LottoNumbers fourthLotto = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(9), new LottoNo(12)));
        LottoNumbers fifthLotto = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(7), new LottoNo(9), new LottoNo(12)));
        List<Lotto> lottos = Arrays.asList(new Lotto(firstLotto), new Lotto(secondLotto), new Lotto(thirdLotto), new Lotto(fourthLotto), new Lotto(fifthLotto));
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6))), new LottoNo(8));
        lottoResult = new LottoResult(lottos, winningNumbers);
    }

    @Test
    public void 로또_6개_일치() {
        assertThat(lottoResult.lottoMatchCount(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    public void 로또_5개_일치() {
        assertThat(lottoResult.lottoMatchCount(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    public void 로또_5개__보너스_일치() {
        assertThat(lottoResult.lottoMatchCount(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    public void 로또_4개_일치() {
        assertThat(lottoResult.lottoMatchCount(LottoRank.FOURTH)).isEqualTo(1);
    }

    @Test
    public void 로또_3개_일치() {
        assertThat(lottoResult.lottoMatchCount(LottoRank.FIFTH)).isEqualTo(1);
    }

}