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
        LottoNumbers firstLotto = LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers secondLotto = LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 5, 8));
        LottoNumbers thirdLotto = LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 5, 12));
        LottoNumbers fourthLotto = LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 9, 12));
        LottoNumbers fifthLotto = LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 7, 9, 12));
        List<Lotto> lottos = Arrays.asList(new Lotto(firstLotto), new Lotto(secondLotto), new Lotto(thirdLotto), new Lotto(fourthLotto), new Lotto(fifthLotto));
        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 5, 6)), 8);
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