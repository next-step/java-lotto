package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 로또_결과를_추가할_수_있다() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoResult.addLotto(lotto);

        assertThat(lottoResult.size()).isEqualTo(1);
        assertThat(lottoResult.getLottoResults()).contains(lotto);
    }

    @Test
    public void 당첨번호에_따라_로또_결과를_계산할_수_있다() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        lottoResult.addLotto(lotto1);
        lottoResult.addLotto(lotto2);

        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoResult.calculateLotto(winningNumber);

        assertThat(lottoResult.getCountByMatchCount(6)).isEqualTo(1);
        assertThat(lottoResult.getCountByMatchCount(0)).isEqualTo(1);
    }

    @Test
    public void 특정_매치_수에_대한_상금을_조회할_수_있다() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoResult.addLotto(lotto);
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoResult.calculateLotto(winningNumber);

        int prizeMoney = lottoResult.getPrizeMoneyByMatchCount(6);

        assertThat(prizeMoney).isEqualTo(2000000000);
    }

    @Test
    public void 특정_매치_수에_대한_수익을_계산할_수_있다() {
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoResult.addLotto(lotto);
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoResult.calculateLotto(winningNumber);

        int earnings = lottoResult.getEarningsByMatchCount(6);

        assertThat(earnings).isEqualTo(lottoResult.getPrizeMoneyByMatchCount(6));
    }
}
